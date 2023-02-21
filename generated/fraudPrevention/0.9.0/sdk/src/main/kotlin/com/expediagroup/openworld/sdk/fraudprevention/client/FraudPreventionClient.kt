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
    package com.expediagroup.openworld.sdk.fraudprevention.client

import com.expediagroup.openworld.sdk.fraudprevention.models.Error
import com.expediagroup.openworld.sdk.fraudprevention.models.ExtendedError
import com.expediagroup.openworld.sdk.fraudprevention.models.OrderPurchaseScreenRequest
import com.expediagroup.openworld.sdk.fraudprevention.models.OrderPurchaseScreenResponse
import com.expediagroup.openworld.sdk.fraudprevention.models.OrderPurchaseUpdateRequest
import com.expediagroup.openworld.sdk.fraudprevention.validation.PropertyConstraintsValidator.validateConstraints

import com.expediagroup.openworld.sdk.core.client.OpenWorldClient
import com.expediagroup.openworld.sdk.core.config.provider.FileConfigurationProvider
import com.expediagroup.openworld.sdk.core.configuration.OpenWorldClientConfiguration
import com.expediagroup.openworld.sdk.core.model.exception.OpenWorldException
import com.expediagroup.openworld.sdk.core.model.exception.service.OpenWorldServiceException

import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.http.ContentType
import io.ktor.http.ParametersBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future
import java.util.UUID

/**
* 
*/
 class FraudPreventionClient private constructor(clientConfiguration: OpenWorldClientConfiguration) : OpenWorldClient(clientConfiguration){
    private val loader = FileConfigurationProvider()[javaClass.classLoader.getResource("sdk.properties")!!]
    private val javaVersion = System.getProperty("java.version")
    private val operatingSystemName = System.getProperty("os.name")
    private val operatingSystemVersion = System.getProperty("os.version")
    private val userAgent = "open-world-sdk-java-fraudprevention/${loader.data()["sdk-version"]!!} (Java $javaVersion; $operatingSystemName $operatingSystemVersion)"

    class Builder : OpenWorldClient.Builder<Builder>() {
        override fun build(): FraudPreventionClient = FraudPreventionClient(
            OpenWorldClientConfiguration(key, secret, endpoint, authEndpoint)
        )
    }

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    private fun HttpRequestBuilder.appendHeaders(transactionId: UUID) {
        headers.append("x-sdk-title", loader.data()["sdk-title"]!!)
        headers.append("transaction-id", transactionId.toString())
        headers.append("User-agent", userAgent)
    }

     override suspend fun throwServiceException(response: HttpResponse) {
         runCatching {
            response.body<Error>()
         }.getOrThrow().let {
            throw OpenWorldServiceException(it.toString())
         }
     }

    private suspend inline fun kscreen(orderPurchaseScreenRequest: OrderPurchaseScreenRequest, transactionId: UUID = UUID.randomUUID()): OrderPurchaseScreenResponse {
        val response = httpClient.request {
            method = HttpMethod.parse("POST")
            url("fraud-prevention/order/purchase/screen")
            appendHeaders(transactionId)
            validateConstraints(orderPurchaseScreenRequest)
            contentType(ContentType.Application.Json)
            setBody(orderPurchaseScreenRequest)
        }
        throwIfError(response)
        return response.body()
    }

    /**
    * Run fraud screening for one transaction
    * The Order Purchase API gives a Fraud recommendation for a transaction. A recommendation can be Accept, Reject, or Review. A transaction is marked as Review whenever there are insufficient signals to recommend Accept or Reject. These incidents are manually reviewed, and a corrected recommendation is made asynchronously. 
     * @param orderPurchaseScreenRequest 
     * @return OrderPurchaseScreenResponse
    */
    @JvmOverloads
    fun screen(orderPurchaseScreenRequest: OrderPurchaseScreenRequest, transactionId: UUID = UUID.randomUUID()) : OrderPurchaseScreenResponse {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                kscreen(orderPurchaseScreenRequest, transactionId)
            }.get()
        } catch (exception: Exception) {
            if (exception is OpenWorldException) throw exception

            when (val cause = exception.cause) {
                is OpenWorldException -> throw cause
                else -> throw OpenWorldException("OpenWorld Error", exception)
            }
        }
    }
    private suspend inline fun kupdate(orderPurchaseUpdateRequest: OrderPurchaseUpdateRequest, transactionId: UUID = UUID.randomUUID()): Void? {
        val response = httpClient.request {
            method = HttpMethod.parse("POST")
            url("fraud-prevention/order/purchase/update")
            appendHeaders(transactionId)
            validateConstraints(orderPurchaseUpdateRequest)
            contentType(ContentType.Application.Json)
            setBody(orderPurchaseUpdateRequest)
        }
        throwIfError(response)
        return null
    }

    /**
    * Send an update for a transaction
    * The Order Purchase Update API is called when the status of the order has changed.  For example, if the customer cancels the reservation, changes reservation in any way, or adds additional products or travelers to the reservation, the Order Purchase Update API is called to notify Expedia Group about the change.  The Order Purchase Update API is also called when the merchant cancels or changes an order based on a Fraud recommendation. 
     * @param orderPurchaseUpdateRequest An OrderPurchaseUpdate request may be of one of the following types &#x60;ORDER_UPDATE&#x60;, &#x60;CHARGEBACK_FEEDBACK&#x60;, &#x60;INSULT_FEEDBACK&#x60;, &#x60;REFUND_UPDATE&#x60;, &#x60;PAYMENT_UPDATE&#x60;. 
     * @return void
    */
    @JvmOverloads
    fun update(orderPurchaseUpdateRequest: OrderPurchaseUpdateRequest, transactionId: UUID = UUID.randomUUID()) : Void? {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                kupdate(orderPurchaseUpdateRequest, transactionId)
            }.get()
        } catch (exception: Exception) {
            if (exception is OpenWorldException) throw exception

            when (val cause = exception.cause) {
                is OpenWorldException -> throw cause
                else -> throw OpenWorldException("OpenWorld Error", exception)
            }
        }
    }
}

