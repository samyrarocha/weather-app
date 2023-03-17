package com.samyrarocha.core.domain.repository

import com.samyrarocha.core.domain.models.Weather

interface WeatherRepository {
    suspend fun getWeatherData(latitude: Double, longitude: Double): Result<Weather>
}