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
package com.expediagroup.openworld.sdk.generators.openapi

import org.openapitools.codegen.api.TemplateDefinition
import org.openapitools.codegen.api.TemplateFileType.API

class ApiTemplate(
    templateFile: String,
    folder: String,
    destinationFilename: String
) : TemplateDefinition(templateFile, folder, destinationFilename) {
    init {
        this.templateType = API
    }
}
