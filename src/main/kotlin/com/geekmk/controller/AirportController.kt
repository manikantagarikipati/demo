package com.geekmk.controller

import com.geekmk.dto.AirportDto
import com.geekmk.entity.Airport
import com.geekmk.service.AirportService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import jakarta.inject.Inject


@ExecuteOn(TaskExecutors.IO)
@Controller("/airport")
class AirportController {

    @Inject
    lateinit var airportService: AirportService

    @Get("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAll():Iterable<Airport>{
        return airportService.getAllAirports()
    }

    @Get("/find/{airportCode}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAirportByCode(airportCode:String):Airport{
        return airportService.getAirportByCode(airportCode)
    }

    @Post("/saveAirport")
    @Produces(MediaType.APPLICATION_JSON)
    fun saveOrUpdate(@Body airport: Airport): Airport {
        print("Request came here")
        return airportService.saveOrupdateAirport(airport)
    }
}