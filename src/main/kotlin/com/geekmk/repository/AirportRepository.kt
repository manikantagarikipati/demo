package com.geekmk.repository

import com.geekmk.entity.Airport
import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import io.micronaut.transaction.SynchronousTransactionManager
import java.sql.Connection
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Repository
abstract class AirportRepository(
        private val entityManager: EntityManager,
        private val transactionManager: SynchronousTransactionManager<Connection>
):CrudRepository<Airport,Long> {

    @Executable
    @Transactional
    fun findByAirportCode(airportCode:String): Airport {
        return transactionManager.executeRead {
            val query = "SELECT at " +
                    "FROM Airport AS at " +
                    "WHERE at.airportCode = :airportCode "
            entityManager.createQuery(query, Airport::class.java)
                    .setParameter("airportCode", airportCode)
                    .singleResult
        }
    }
}