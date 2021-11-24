package com.geekmk.controller

import com.geekmk.service.PaymentService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject

@Controller("/payment")
class PaymentController {

    @Inject
    lateinit var paymentService: PaymentService

    @Get("/")
    fun getUserName():String{
        return paymentService.getName()
    }
}