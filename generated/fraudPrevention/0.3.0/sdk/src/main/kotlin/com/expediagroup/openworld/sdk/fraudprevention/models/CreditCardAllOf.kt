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

import com.expediagroup.openworld.sdk.fraudprevention.models.Telephone

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Length;

/**
 * 
 * @param cardType Type of card used for payment, (eg. `CREDIT`, `DEBIT`).
 * @param cardNumber All the digits (unencrypted) of the credit card number associated with the payment.
 * @param cardAvsResponse A field used to confirm if the address provided at the time of purchase matches what the bank has on file for the Credit Card.
 * @param cardCvvResponse A field used to confirm the Card Verification Value on the Credit Card matches the Credit Card used at the time of purchase.
 * @param telephones Telephone(s) associated with card holder and credit card.
 * @param expiryDate Expiration date of the credit card used for payment.
 * @param electronicCommerceIndicator Electronic Commerce Indicator, a two or three digit number usually returned by a 3rd party payment processor in regards to the authentication used when gathering the cardholder's payment credentials.
 * @param virtualCreditCardFlag A flag to indicate that the bank card being used for the charge is a virtual credit card.
 * @param walletType If a virtual/digital form of payment was used, the type of digital wallet should be specified here. Possible `wallet_type`'s include: `Google` or `ApplePay`.
 * @param merchantOrderCode Reference code passed to acquiring bank at the time of payment. This code is the key ID that ties back to payments data at the payment level.
 */
data class CreditCardAllOf(
    /* Type of card used for payment, (eg. `CREDIT`, `DEBIT`). */
@JsonProperty("card_type")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    val cardType: kotlin.String,

    /* All the digits (unencrypted) of the credit card number associated with the payment. */
@JsonProperty("card_number")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    val cardNumber: kotlin.String,

    /* A field used to confirm if the address provided at the time of purchase matches what the bank has on file for the Credit Card. */
@JsonProperty("card_avs_response")

    @field:Length(max = 50)
    
    
    
    @field:Valid
    val cardAvsResponse: kotlin.String,

    /* A field used to confirm the Card Verification Value on the Credit Card matches the Credit Card used at the time of purchase. */
@JsonProperty("card_cvv_response")

    @field:Length(max = 20)
    
    
    
    @field:Valid
    val cardCvvResponse: kotlin.String,

    /* Telephone(s) associated with card holder and credit card. */
@JsonProperty("telephones")

    
    @field:Size(min = 1, max = 20)
    
    
    @field:Valid
    val telephones: kotlin.collections.List<Telephone>,

    /* Expiration date of the credit card used for payment. */
@JsonProperty("expiry_date")

    val expiryDate: java.time.OffsetDateTime? = null,

    /* Electronic Commerce Indicator, a two or three digit number usually returned by a 3rd party payment processor in regards to the authentication used when gathering the cardholder's payment credentials. */
@JsonProperty("electronic_commerce_indicator")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    val electronicCommerceIndicator: kotlin.String? = null,

    /* A flag to indicate that the bank card being used for the charge is a virtual credit card. */
@JsonProperty("virtual_credit_card_flag")

    
    
    
    
    @field:Valid
    val virtualCreditCardFlag: kotlin.Boolean? = null,

    /* If a virtual/digital form of payment was used, the type of digital wallet should be specified here. Possible `wallet_type`'s include: `Google` or `ApplePay`. */
@JsonProperty("wallet_type")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    val walletType: kotlin.String? = null,

    /* Reference code passed to acquiring bank at the time of payment. This code is the key ID that ties back to payments data at the payment level. */
@JsonProperty("merchant_order_code")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    val merchantOrderCode: kotlin.String? = null
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var cardType: kotlin.String? = null,
        private var cardNumber: kotlin.String? = null,
        private var cardAvsResponse: kotlin.String? = null,
        private var cardCvvResponse: kotlin.String? = null,
        private var telephones: kotlin.collections.List<Telephone>? = null,
        private var expiryDate: java.time.OffsetDateTime? = null,
        private var electronicCommerceIndicator: kotlin.String? = null,
        private var virtualCreditCardFlag: kotlin.Boolean? = null,
        private var walletType: kotlin.String? = null,
        private var merchantOrderCode: kotlin.String? = null
    ) {
        fun cardType(cardType: kotlin.String) = apply { this.cardType = cardType }
        fun cardNumber(cardNumber: kotlin.String) = apply { this.cardNumber = cardNumber }
        fun cardAvsResponse(cardAvsResponse: kotlin.String) = apply { this.cardAvsResponse = cardAvsResponse }
        fun cardCvvResponse(cardCvvResponse: kotlin.String) = apply { this.cardCvvResponse = cardCvvResponse }
        fun telephones(telephones: kotlin.collections.List<Telephone>) = apply { this.telephones = telephones }
        fun expiryDate(expiryDate: java.time.OffsetDateTime) = apply { this.expiryDate = expiryDate }
        fun electronicCommerceIndicator(electronicCommerceIndicator: kotlin.String) = apply { this.electronicCommerceIndicator = electronicCommerceIndicator }
        fun virtualCreditCardFlag(virtualCreditCardFlag: kotlin.Boolean) = apply { this.virtualCreditCardFlag = virtualCreditCardFlag }
        fun walletType(walletType: kotlin.String) = apply { this.walletType = walletType }
        fun merchantOrderCode(merchantOrderCode: kotlin.String) = apply { this.merchantOrderCode = merchantOrderCode }

        fun build(): CreditCardAllOf {
            // Check required params
            validateNullity()
            return CreditCardAllOf(
                cardType = cardType!!,
                cardNumber = cardNumber!!,
                cardAvsResponse = cardAvsResponse!!,
                cardCvvResponse = cardCvvResponse!!,
                telephones = telephones!!,
                expiryDate = expiryDate,
                electronicCommerceIndicator = electronicCommerceIndicator,
                virtualCreditCardFlag = virtualCreditCardFlag,
                walletType = walletType,
                merchantOrderCode = merchantOrderCode
            )
        }

        private fun validateNullity() {
            if (cardType == null) {
                throw NullPointerException("Required parameter cardType is missing")
            }
            if (cardNumber == null) {
                throw NullPointerException("Required parameter cardNumber is missing")
            }
            if (cardAvsResponse == null) {
                throw NullPointerException("Required parameter cardAvsResponse is missing")
            }
            if (cardCvvResponse == null) {
                throw NullPointerException("Required parameter cardCvvResponse is missing")
            }
            if (telephones == null) {
                throw NullPointerException("Required parameter telephones is missing")
            }
        }
    }
}

