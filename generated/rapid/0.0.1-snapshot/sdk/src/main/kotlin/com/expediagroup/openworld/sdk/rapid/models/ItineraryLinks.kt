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

 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.expediagroup.openworld.sdk.rapid.models

import com.expediagroup.openworld.sdk.rapid.models.Link

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Length;

/**
 * A map of links, including links to resume or cancel a held booking. This is only included for held bookings.
 * @param resume 
 * @param cancel 
 */
data class ItineraryLinks(
    @JsonProperty("resume")

    
    
    
    
    @field:Valid
    val resume: Link? = null,

    @JsonProperty("cancel")

    
    
    
    
    @field:Valid
    val cancel: Link? = null
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var resume: Link? = null,
        private var cancel: Link? = null
    ) {
        fun resume(resume: Link) = apply { this.resume = resume }
        fun cancel(cancel: Link) = apply { this.cancel = cancel }

        fun build(): ItineraryLinks {
            return ItineraryLinks(
                resume = resume,
                cancel = cancel
            )
        }

    }
}

