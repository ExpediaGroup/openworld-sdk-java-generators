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

import com.expediagroup.sdk.generators.openapi.PreProcessingException

internal interface Traversable {

    companion object {
        fun convertToMutableMap(obj: Any?): MutableMap<Any?, Any?> {
            if (obj is Map<*, *>) {
                return obj.toMutableMap()
            }
            throw PreProcessingException("Could not convert object to map")
        }

        fun convertToMutableList(obj: Any?): MutableList<Any?> {
            if (obj is List<*>) {
                return obj.toMutableList()
            }
            throw PreProcessingException("Could not convert object to list")
        }
    }
}
