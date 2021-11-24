package com.geekmk

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.core.annotation.NonNull;

@ConfigurationProperties("application")
class ApplicationConfigurationProperties : ApplicationConfiguration {
    protected val DEFAULT_MAX = 10

    @get:NonNull
    @NonNull
    override var max = DEFAULT_MAX
        set(max) {
            if (max != null) {
                field = max
            }
        }
}