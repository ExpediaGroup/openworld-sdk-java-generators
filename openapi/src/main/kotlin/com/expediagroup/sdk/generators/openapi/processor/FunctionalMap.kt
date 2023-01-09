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

import com.expediagroup.sdk.generators.openapi.processor.YamlProcessor.Companion.convertToMutableList
import com.expediagroup.sdk.generators.openapi.processor.YamlProcessor.Companion.convertToMutableMap

internal class FunctionalMap(val map: MutableMap<Any?, Any?>) {
    fun get(key: String) = map[key]

    fun put(key: String, value: List<Any?>) {
        map[key] = value
    }

    fun put(key: String, value: Map<Any?, Any?>) {
        map[key] = value
    }

    fun mapApply(key: String, block: (FunctionalMap) -> Unit) {
        val traversingMap = convertToMutableMap(map[key] ?: mapOf<Any?, Any?>())
        block(FunctionalMap(traversingMap))
        put(key, traversingMap)
    }

    fun listApply(key: String, block: (FunctionalList) -> Unit) {
        val traversingList = convertToMutableList(map[key] ?: listOf<Any?>())
        block(FunctionalList(traversingList))
        put(key, traversingList)
    }

    fun forEachMap(block: (FunctionalMap) -> Unit) {
        for (key in map.keys) {
            val childMap = convertToMutableMap(map[key])
            block(FunctionalMap(childMap))
            map[key] = childMap
        }
    }
}
