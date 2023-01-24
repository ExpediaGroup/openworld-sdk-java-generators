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

import com.expediagroup.openworld.sdk.fraudprevention.models.Address
import com.expediagroup.openworld.sdk.fraudprevention.models.Amount
import com.expediagroup.openworld.sdk.fraudprevention.models.Name
import com.expediagroup.openworld.sdk.fraudprevention.models.Operations
import com.expediagroup.openworld.sdk.fraudprevention.models.PaymentMethod
import com.expediagroup.openworld.sdk.fraudprevention.models.PaymentReason
import com.expediagroup.openworld.sdk.fraudprevention.models.PaymentThreeDSCriteria

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
 * @param brand Payment brand used for payment on this transaction.
 * @param method 
 * @param billingName 
 * @param reason 
 * @param billingAddress 
 * @param billingEmailAddress Email address associated with the payment.
 * @param authorizedAmount 
 * @param verifiedAmount 
 * @param threeDigitsSecureCriteria 
 * @param operations 
 * @param totalRefundAmount Total amount refunded towards the transaction.
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = ["method"])
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "method", visible = true)
@JsonSubTypes(
    Type(value = CreditCard::class, name = "CREDIT_CARD"),
    Type(value = PayPal::class, name = "PAYPAL"),
    Type(value = Points::class, name = "POINTS")
)
interface Payment {

        /* Payment brand used for payment on this transaction. */

val brand: kotlin.String
    
val method: PaymentMethod
    
val billingName: Name
    val reason: PaymentReason?
    val billingAddress: Address?
        /* Email address associated with the payment. */
val billingEmailAddress: kotlin.String?
    val authorizedAmount: Amount?
    val verifiedAmount: Amount?
    val threeDigitsSecureCriteria: PaymentThreeDSCriteria?
    val operations: Operations?
        /* Total amount refunded towards the transaction. */
val totalRefundAmount: kotlin.Double?
}
