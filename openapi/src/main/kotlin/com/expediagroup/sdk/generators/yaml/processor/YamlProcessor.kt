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
package com.expediagroup.sdk.generators.yaml.processor

import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.Yaml
import java.io.File
import kotlin.io.path.Path
import kotlin.io.path.inputStream

internal class YamlProcessor(path: String) {
    private val yaml = Yaml(createDumperOptions())
    private val rootMap: MutableMap<String, Any>

    init {
        val inputStream = Path(path).inputStream()
        rootMap = yaml.load<Map<String, Any>>(inputStream).toMutableMap()
    }

    fun unifyTags(tag: String) {
        removeTags(rootMap, tag)
        replacePathsTags(rootMap, tag)
    }

    fun dump(output: File) {
        yaml.dump(rootMap, output.bufferedWriter())
    }

    private fun replacePathsTags(map: MutableMap<String, Any>, title: String) {
        val pathsMap = getMap(map[PATHS])

        for (pathKey in pathsMap.keys) {
            val pathMap = getMap(pathsMap[pathKey])
            for (methodKey in pathMap.keys) {
                val methodMap = getMap(pathMap[methodKey])
                methodMap[TAGS] = listOf(title)
                pathMap[methodKey] = methodMap
            }
            pathsMap[pathKey] = pathMap
        }
        map[PATHS] = pathsMap
    }

    private fun removeTags(map: MutableMap<String, Any>, title: String) {
        val tagsList = listOf(mapOf(Pair(NAME, title)))
        map[TAGS] = tagsList
    }

    private fun getMap(obj: Any?): MutableMap<Any?, Any?> {
        if (obj is Map<*, *>) {
            return obj.toMutableMap()
        }
        throw PreProcessingException(obj)
    }

    companion object {
        private const val NAME = "name"
        private const val PATHS = "paths"
        private const val TAGS = "tags"
        fun createDumperOptions(): DumperOptions {
            val options = DumperOptions()
            options.indent = 2
            options.defaultScalarStyle = DumperOptions.ScalarStyle.PLAIN
            options.defaultFlowStyle = DumperOptions.FlowStyle.BLOCK
            options.indicatorIndent = 2
            options.indentWithIndicator = true
            return options
        }
    }
}
