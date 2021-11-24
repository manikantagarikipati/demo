package com.geekmk.entity

import io.micronaut.core.annotation.Introspected
import javax.persistence.*

@Introspected
@Entity
@Table(name = "AIRPORT",schema = "public")
data class Airport(

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apt_id_seq")
        @SequenceGenerator(name = "apt_id_seq", sequenceName = "apt_id_seq", allocationSize = 1)
        val id: Long = 0,

        @Column(name = "aptcode")
        var airportCode: String = "",

        @Column(name = "aptname")
        var airportName: String ="",

        @Column(name = "cityname")
        var cityName: String = "",

        @Column(name = "country")
        var countryName: String = "",
)