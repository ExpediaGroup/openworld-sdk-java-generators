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
package com.expediagroup.openworld.sdk.fraudprevention.models

import com.expediagroup.openworld.sdk.fraudprevention.models.UpdateType

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo

/**
 * 
 * @param type 
 * @param riskId The `risk_id` provided by Expedia's Fraud Prevention Service in the `OrderPurchaseScreenResponse`.
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = ["type"])
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes(
    Type(value = ChargebackFeedback::class, name = "CHARGEBACK_FEEDBACK"),
    Type(value = InsultFeedback::class, name = "INSULT_FEEDBACK"),
    Type(value = OrderUpdate::class, name = "ORDER_UPDATE"),
    Type(value = PaymentUpdate::class, name = "PAYMENT_UPDATE"),
    Type(value = RefundUpdate::class, name = "REFUND_UPDATE")
)
interface OrderPurchaseUpdateRequest {

    
val type: UpdateType
        /* The `risk_id` provided by Expedia's Fraud Prevention Service in the `OrderPurchaseScreenResponse`. */

val riskId: kotlin.String
}

