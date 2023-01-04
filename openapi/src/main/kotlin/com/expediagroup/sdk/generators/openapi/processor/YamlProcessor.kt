/*
 * Copyright (C) 2022 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expediagroup.sdk.generators.openapi.processor

import com.expediagroup.sdk.generators.openapi.Constant
import com.expediagroup.sdk.generators.openapi.Constant.INDENTATION_LENGTH
import com.expediagroup.sdk.generators.openapi.Constant.INDENT_WITH_INDICATOR
import com.expediagroup.sdk.generators.openapi.Constant.INDICATOR_INDENTATION_LENGTH
import com.expediagroup.sdk.generators.openapi.PreProcessingException
import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.Yaml
import java.nio.file.Files
import java.util.*
import kotlin.io.path.Path
import kotlin.io.path.inputStream

internal class YamlProcessor(path: String, namespace: String) {
    private val yaml = Yaml(dumperOptions)
    private val rootMap: MutableMap<String, Any>
    private val tag: String

    init {
        val inputStream = Path(path).inputStream()
        rootMap = yaml.load<Map<String, Any>>(inputStream).toMutableMap()
        tag = camelCase(namespace)
    }

    fun process(): String {
        unifyTags()
        removeUnwantedHeaders()
        return dump()
    }

    private fun unifyTags() {
        replaceTagsWith(rootMap, tag)
        replacePathsTags(rootMap, tag)
    }

    private fun replaceTagsWith(map: MutableMap<String, Any>, tag: String) {
        val tagsList = listOf(mapOf(Pair(NAME, tag)))
        map[TAGS] = tagsList
    }

    private fun replacePathsTags(map: MutableMap<String, Any>, tag: String) {
        val pathsMap = convertToMutableMap(map[PATHS])

        for (pathKey in pathsMap.keys) {
            val pathMap = convertToMutableMap(pathsMap[pathKey])
            for (methodKey in pathMap.keys) {
                val methodMap = convertToMutableMap(pathMap[methodKey])
                methodMap[TAGS] = listOf(tag)
                pathMap[methodKey] = methodMap
            }
            pathsMap[pathKey] = pathMap
        }
        map[PATHS] = pathsMap
    }

    private fun convertToMutableMap(obj: Any?): MutableMap<Any?, Any?> {
        if (obj is Map<*, *>) {
            return obj.toMutableMap()
        }
        throw PreProcessingException("Could not convert object to map")
    }

    private fun removeUnwantedHeaders() {
        val pathsMap = convertToMutableMap(rootMap[PATHS])

        for (pathKey in pathsMap.keys) {
            val pathMap = convertToMutableMap(pathsMap[pathKey])
            for (methodKey in pathMap.keys) {
                val methodMap = convertToMutableMap(pathMap[methodKey])
                val parametersList = convertToMutableList(methodMap[PARAMETERS])
                val updatedParametersList = mutableListOf<Any>()
                for (parameter in parametersList) {
                    val parameterMap = convertToMutableMap(parameter)
                    if (!isUnwantedHeader(parameterMap)) {
                        updatedParametersList.add(parameterMap)
                    }
                }
                methodMap[PARAMETERS] = updatedParametersList
                pathMap[methodKey] = methodMap
            }
            pathsMap[pathKey] = pathMap
        }
        rootMap[PATHS] = pathsMap
    }

    private fun isUnwantedHeader(parameterMap: MutableMap<Any?, Any?>) =
        parameterMap[IN] == HEADER && UNWANTED_HEADERS.contains((parameterMap[NAME] as String).lowercase())

    private fun convertToMutableList(obj: Any?): List<Any?> {
        if (obj is List<*>) {
            return obj.toMutableList()
        }
        throw PreProcessingException("Could not convert object to map")
    }

    private fun dump(): String {
        val tempFile = Files.createTempFile(UUID.randomUUID().toString(), "temp").toFile()
        yaml.dump(rootMap, tempFile.bufferedWriter())
        return tempFile.path
    }

    companion object {
        private const val NAME = "name"
        private const val PATHS = "paths"
        private const val TAGS = "tags"
        private const val PARAMETERS = "parameters"
        private const val IN = "in"
        private const val HEADER = "header"
        private val UNWANTED_HEADERS =
            listOf("accept", "accept-encoding", "user-agent", "authorization", "content-type")
        private val dumperOptions = DumperOptions()

        init {
            dumperOptions.indent = INDENTATION_LENGTH
            dumperOptions.indentWithIndicator = INDENT_WITH_INDICATOR
            dumperOptions.indicatorIndent = INDICATOR_INDENTATION_LENGTH
            dumperOptions.defaultFlowStyle = DumperOptions.FlowStyle.BLOCK
            dumperOptions.defaultScalarStyle = DumperOptions.ScalarStyle.PLAIN
        }

        private fun camelCase(string: String): String {
            return string.split(Constant.NON_ALPHANUMERIC_REGEX).joinToString("") { capitalize(it) }
        }

        private fun capitalize(string: String) = string.replaceFirstChar { it.uppercaseChar() }
    }
}
