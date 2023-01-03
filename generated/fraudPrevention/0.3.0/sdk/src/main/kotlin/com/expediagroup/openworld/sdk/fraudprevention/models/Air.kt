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

import com.expediagroup.openworld.sdk.fraudprevention.models.AirSegment
import com.expediagroup.openworld.sdk.fraudprevention.models.Amount
import com.expediagroup.openworld.sdk.fraudprevention.models.TravelProduct

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Length;

/**
 * 
 * @param departureTime Local date and time of departure from original departure location, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param arrivalTime Local date and time of arrival to final destination location, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param airSegments Additional airline and flight details for each of the trip segments.
 * @param flightType Identifies the type of air trip based on the air destinations.
 * @param passengerNameRecord Airline booking confirmation code for the trip.
 * @param globalDistributionSystemType Associated with Passenger Name Record (PNR).
 */
data class Air(
    @JsonProperty("price")

    
    
    
    
    @field:Valid
    override val price: Amount,

    /* Type of product advertised on the website. */
@JsonProperty("type")

    @field:Length(max = 40)
    
    
    
    @field:Valid
    override val type: kotlin.String,

    /* Type of inventory. */
@JsonProperty("inventory_type")

    @field:Length(max = 30)
    
    
    
    @field:Valid
    override val inventoryType: kotlin.String,

    /* Identifies the business model through which the supply is being sold. Merchant/Agency. */
@JsonProperty("inventory_source")

    override val inventorySource: TravelProduct.InventorySource,

    /* List of travelerGuids who are part of the traveling party on the order for the product. */
@JsonProperty("travelers_references")

    
    @field:Size(min = 1, max = 40)
    
    
    @field:Valid
    override val travelersReferences: kotlin.collections.List<kotlin.String>,

    /* Local date and time of departure from original departure location, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. */
@JsonProperty("departure_time")

    val departureTime: java.time.OffsetDateTime,

    /* Local date and time of arrival to final destination location, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. */
@JsonProperty("arrival_time")

    val arrivalTime: java.time.OffsetDateTime,

    /* Additional airline and flight details for each of the trip segments. */
@JsonProperty("air_segments")

    
    @field:Size(min = 1, max = 30)
    
    
    @field:Valid
    val airSegments: kotlin.collections.List<AirSegment>,

    /* Identifies the type of air trip based on the air destinations. */
@JsonProperty("flight_type")

    val flightType: Air.FlightType? = null,

    /* Airline booking confirmation code for the trip. */
@JsonProperty("passenger_name_record")

    @field:Length(max = 100)
    
    
    
    @field:Valid
    val passengerNameRecord: kotlin.String? = null,

    /* Associated with Passenger Name Record (PNR). */
@JsonProperty("global_distribution_system_type")

    @field:Length(max = 100)
    
    
    
    @field:Valid
    val globalDistributionSystemType: kotlin.String? = null
) : TravelProduct {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var price: Amount? = null,
        private var type: kotlin.String? = null,
        private var inventoryType: kotlin.String? = null,
        private var inventorySource: TravelProduct.InventorySource? = null,
        private var travelersReferences: kotlin.collections.List<kotlin.String>? = null,
        private var departureTime: java.time.OffsetDateTime? = null,
        private var arrivalTime: java.time.OffsetDateTime? = null,
        private var airSegments: kotlin.collections.List<AirSegment>? = null,
        private var flightType: Air.FlightType? = null,
        private var passengerNameRecord: kotlin.String? = null,
        private var globalDistributionSystemType: kotlin.String? = null
    ) {
        fun price(price: Amount) = apply { this.price = price }
        fun type(type: kotlin.String) = apply { this.type = type }
        fun inventoryType(inventoryType: kotlin.String) = apply { this.inventoryType = inventoryType }
        fun inventorySource(inventorySource: TravelProduct.InventorySource) = apply { this.inventorySource = inventorySource }
        fun travelersReferences(travelersReferences: kotlin.collections.List<kotlin.String>) = apply { this.travelersReferences = travelersReferences }
        fun departureTime(departureTime: java.time.OffsetDateTime) = apply { this.departureTime = departureTime }
        fun arrivalTime(arrivalTime: java.time.OffsetDateTime) = apply { this.arrivalTime = arrivalTime }
        fun airSegments(airSegments: kotlin.collections.List<AirSegment>) = apply { this.airSegments = airSegments }
        fun flightType(flightType: Air.FlightType) = apply { this.flightType = flightType }
        fun passengerNameRecord(passengerNameRecord: kotlin.String) = apply { this.passengerNameRecord = passengerNameRecord }
        fun globalDistributionSystemType(globalDistributionSystemType: kotlin.String) = apply { this.globalDistributionSystemType = globalDistributionSystemType }

        fun build(): Air {
            // Check required params
            validateNullity()
            return Air(
                price = price!!,
                type = type!!,
                inventoryType = inventoryType!!,
                inventorySource = inventorySource!!,
                travelersReferences = travelersReferences!!,
                departureTime = departureTime!!,
                arrivalTime = arrivalTime!!,
                airSegments = airSegments!!,
                flightType = flightType,
                passengerNameRecord = passengerNameRecord,
                globalDistributionSystemType = globalDistributionSystemType
            )
        }

        private fun validateNullity() {
            if (price == null) {
                throw NullPointerException("Required parameter price is missing")
            }
            if (type == null) {
                throw NullPointerException("Required parameter type is missing")
            }
            if (inventoryType == null) {
                throw NullPointerException("Required parameter inventoryType is missing")
            }
            if (inventorySource == null) {
                throw NullPointerException("Required parameter inventorySource is missing")
            }
            if (travelersReferences == null) {
                throw NullPointerException("Required parameter travelersReferences is missing")
            }
            if (departureTime == null) {
                throw NullPointerException("Required parameter departureTime is missing")
            }
            if (arrivalTime == null) {
                throw NullPointerException("Required parameter arrivalTime is missing")
            }
            if (airSegments == null) {
                throw NullPointerException("Required parameter airSegments is missing")
            }
        }
    }

    /**
     * Identifies the type of air trip based on the air destinations.
     * Values: ROUNDTRIP,ONEWAY,MULTIPLE_DESTINATION
     */
    enum class FlightType(val value: kotlin.String) {
        @JsonProperty("ROUNDTRIP")
        ROUNDTRIP("ROUNDTRIP"),
        
        @JsonProperty("ONEWAY")
        ONEWAY("ONEWAY"),
        
        @JsonProperty("MULTIPLE_DESTINATION")
        MULTIPLE_DESTINATION("MULTIPLE_DESTINATION");
    }
}

