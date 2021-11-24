package com.geekmk.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.geekmk.entity.Airport

data class AirportDto(
        @JsonProperty("id")
        val id: Long,

        @JsonProperty("aptcode")
        var airportCode: String,

        @JsonProperty("aptname")
        var airportName: String,

        @JsonProperty("cityname")
        var cityName: String,

        @JsonProperty("country")
        var countryName: String,
)

fun AirportDto.toAirPort():Airport{
        return Airport(this.id,this.airportCode,this.airportName,this.cityName,this.countryName)
}