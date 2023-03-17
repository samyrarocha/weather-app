package com.samyrarocha.core.domain.models

data class Weather(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val currentWeather: CurrentWeather,
    val daily: Daily
)