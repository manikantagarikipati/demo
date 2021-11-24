package com.geekmk.service

import jakarta.inject.Singleton

@Singleton
class PaymentService {

    fun getName():String{
        return "Response from service class"
    }
}