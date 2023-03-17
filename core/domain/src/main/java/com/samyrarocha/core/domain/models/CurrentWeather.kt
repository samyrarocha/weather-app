package com.samyrarocha.core.domain.models

data class CurrentWeather(
    val temperature: Float,
    val windSpeed: Float,
    val windDirection: Float,
    val weatherCode: Int,
    val time: String
)
