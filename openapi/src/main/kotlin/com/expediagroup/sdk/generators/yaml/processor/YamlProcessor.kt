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

    fun unifyTags() {
        val title = getTitle(rootMap)

        removeTags(rootMap, title)
        replacePathsTags(rootMap, title)
    }

    fun dump(output: File) {
        yaml.dump(rootMap, output.bufferedWriter())
    }

    private fun replacePathsTags(map: MutableMap<String, Any>, title: String) {
        val pathsMap = getMap(map["paths"])

        for (pathKey in pathsMap.keys) {
            val pathMap = getMap(pathsMap[pathKey])
            for (methodKey in pathMap.keys) {
                val methodMap = getMap(pathMap[methodKey])
                methodMap["tags"] = listOf(title)
                pathMap[methodKey] = methodMap
            }
            pathsMap[pathKey] = pathMap
        }
        map["paths"] = pathsMap
    }

    private fun removeTags(map: MutableMap<String, Any>, title: String) {
        val tagsList = listOf(mapOf(Pair("name", title)))
        map["tags"] = tagsList
    }

    private fun getTitle(map: Map<String, Any>): String {
        return getMap(map["info"])["title"] as String
    }

    private fun getMap(obj: Any?): MutableMap<Any?, Any?> {
        if (obj is Map<*, *>) {
            return obj.toMutableMap()
        }
        throw PreProcessingException(obj)
    }

    companion object {
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
