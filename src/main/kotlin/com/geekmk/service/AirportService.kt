package com.geekmk.service

import com.geekmk.dto.AirportDto
import com.geekmk.dto.toAirPort
import com.geekmk.entity.Airport
import com.geekmk.repository.AirportRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton


@Singleton
class AirportService{

    @Inject
    lateinit var airportRepository: AirportRepository

    fun getAirportByCode(airportCode: String): Airport {
        return airportRepository.findByAirportCode(airportCode)
    }

    fun getAllAirports():Iterable<Airport> {
        return airportRepository.findAll()
    }

    fun saveOrupdateAirport(airport: Airport): Airport {
        val airportSaved: Airport = if (airport.id != null && airportRepository.existsById(airport.id)) {
            airportRepository.update(airport)
        } else {
            airportRepository.save(airport)
        }
        return airportSaved
    }

    fun deleteAirport(airportId: Long) {
        airportRepository.deleteById(airportId)
    }

}