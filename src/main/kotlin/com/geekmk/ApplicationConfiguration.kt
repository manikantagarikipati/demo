package com.geekmk

import javax.validation.constraints.NotNull

interface ApplicationConfiguration {
    @get:NotNull
    val max: Int
}