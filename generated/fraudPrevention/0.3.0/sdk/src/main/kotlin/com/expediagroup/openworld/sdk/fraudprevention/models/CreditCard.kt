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
import com.expediagroup.openworld.sdk.fraudprevention.models.Payment
import com.expediagroup.openworld.sdk.fraudprevention.models.PaymentMethod
import com.expediagroup.openworld.sdk.fraudprevention.models.PaymentReason
import com.expediagroup.openworld.sdk.fraudprevention.models.PaymentThreeDSCriteria
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
data class CreditCard(
    /* Payment brand used for payment on this transaction. */
@JsonProperty("brand")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    override val brand: kotlin.String,

    @JsonProperty("method")

    
    
    
    
    @field:Valid
    override val method: PaymentMethod,

    @JsonProperty("billing_name")

    
    
    
    
    @field:Valid
    override val billingName: Name,

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

    @JsonProperty("reason")

    
    
    
    
    @field:Valid
    override val reason: PaymentReason? = null,

    @JsonProperty("billing_address")

    
    
    
    
    @field:Valid
    override val billingAddress: Address? = null,

    /* Email address associated with the payment. */
@JsonProperty("billing_email_address")

    @field:Length(max = 200)
    
    
    
    @field:Valid
    override val billingEmailAddress: kotlin.String? = null,

    @JsonProperty("authorized_amount")

    
    
    
    
    @field:Valid
    override val authorizedAmount: Amount? = null,

    @JsonProperty("verified_amount")

    
    
    
    
    @field:Valid
    override val verifiedAmount: Amount? = null,

    @JsonProperty("three_digits_secure_criteria")

    
    
    
    
    @field:Valid
    override val threeDigitsSecureCriteria: PaymentThreeDSCriteria? = null,

    @JsonProperty("operations")

    
    
    
    
    @field:Valid
    override val operations: Operations? = null,

    /* Total amount refunded towards the transaction. */
@JsonProperty("total_refund_amount")

    override val totalRefundAmount: kotlin.Double? = null,

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
) : Payment {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var brand: kotlin.String? = null,
        private var method: PaymentMethod? = null,
        private var billingName: Name? = null,
        private var cardType: kotlin.String? = null,
        private var cardNumber: kotlin.String? = null,
        private var cardAvsResponse: kotlin.String? = null,
        private var cardCvvResponse: kotlin.String? = null,
        private var telephones: kotlin.collections.List<Telephone>? = null,
        private var reason: PaymentReason? = null,
        private var billingAddress: Address? = null,
        private var billingEmailAddress: kotlin.String? = null,
        private var authorizedAmount: Amount? = null,
        private var verifiedAmount: Amount? = null,
        private var threeDigitsSecureCriteria: PaymentThreeDSCriteria? = null,
        private var operations: Operations? = null,
        private var totalRefundAmount: kotlin.Double? = null,
        private var expiryDate: java.time.OffsetDateTime? = null,
        private var electronicCommerceIndicator: kotlin.String? = null,
        private var virtualCreditCardFlag: kotlin.Boolean? = null,
        private var walletType: kotlin.String? = null,
        private var merchantOrderCode: kotlin.String? = null
    ) {
        fun brand(brand: kotlin.String) = apply { this.brand = brand }
        fun method(method: PaymentMethod) = apply { this.method = method }
        fun billingName(billingName: Name) = apply { this.billingName = billingName }
        fun cardType(cardType: kotlin.String) = apply { this.cardType = cardType }
        fun cardNumber(cardNumber: kotlin.String) = apply { this.cardNumber = cardNumber }
        fun cardAvsResponse(cardAvsResponse: kotlin.String) = apply { this.cardAvsResponse = cardAvsResponse }
        fun cardCvvResponse(cardCvvResponse: kotlin.String) = apply { this.cardCvvResponse = cardCvvResponse }
        fun telephones(telephones: kotlin.collections.List<Telephone>) = apply { this.telephones = telephones }
        fun reason(reason: PaymentReason) = apply { this.reason = reason }
        fun billingAddress(billingAddress: Address) = apply { this.billingAddress = billingAddress }
        fun billingEmailAddress(billingEmailAddress: kotlin.String) = apply { this.billingEmailAddress = billingEmailAddress }
        fun authorizedAmount(authorizedAmount: Amount) = apply { this.authorizedAmount = authorizedAmount }
        fun verifiedAmount(verifiedAmount: Amount) = apply { this.verifiedAmount = verifiedAmount }
        fun threeDigitsSecureCriteria(threeDigitsSecureCriteria: PaymentThreeDSCriteria) = apply { this.threeDigitsSecureCriteria = threeDigitsSecureCriteria }
        fun operations(operations: Operations) = apply { this.operations = operations }
        fun totalRefundAmount(totalRefundAmount: kotlin.Double) = apply { this.totalRefundAmount = totalRefundAmount }
        fun expiryDate(expiryDate: java.time.OffsetDateTime) = apply { this.expiryDate = expiryDate }
        fun electronicCommerceIndicator(electronicCommerceIndicator: kotlin.String) = apply { this.electronicCommerceIndicator = electronicCommerceIndicator }
        fun virtualCreditCardFlag(virtualCreditCardFlag: kotlin.Boolean) = apply { this.virtualCreditCardFlag = virtualCreditCardFlag }
        fun walletType(walletType: kotlin.String) = apply { this.walletType = walletType }
        fun merchantOrderCode(merchantOrderCode: kotlin.String) = apply { this.merchantOrderCode = merchantOrderCode }

        fun build(): CreditCard {
            // Check required params
            validateNullity()
            return CreditCard(
                brand = brand!!,
                method = method!!,
                billingName = billingName!!,
                cardType = cardType!!,
                cardNumber = cardNumber!!,
                cardAvsResponse = cardAvsResponse!!,
                cardCvvResponse = cardCvvResponse!!,
                telephones = telephones!!,
                reason = reason,
                billingAddress = billingAddress,
                billingEmailAddress = billingEmailAddress,
                authorizedAmount = authorizedAmount,
                verifiedAmount = verifiedAmount,
                threeDigitsSecureCriteria = threeDigitsSecureCriteria,
                operations = operations,
                totalRefundAmount = totalRefundAmount,
                expiryDate = expiryDate,
                electronicCommerceIndicator = electronicCommerceIndicator,
                virtualCreditCardFlag = virtualCreditCardFlag,
                walletType = walletType,
                merchantOrderCode = merchantOrderCode
            )
        }

        private fun validateNullity() {
            if (brand == null) {
                throw NullPointerException("Required parameter brand is missing")
            }
            if (method == null) {
                throw NullPointerException("Required parameter method is missing")
            }
            if (billingName == null) {
                throw NullPointerException("Required parameter billingName is missing")
            }
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

