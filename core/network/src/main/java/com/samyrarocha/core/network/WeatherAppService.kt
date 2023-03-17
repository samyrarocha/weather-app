package com.samyrarocha.core.network

import com.samyrarocha.core.network.models.ApiWeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAppService {
    @GET("/v1/forecast")
    suspend fun getWeatherData(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("daily") daily: String,
        @Query("current_weather") currentWeather: Boolean,
        @Query("timezone") timezone: String
    ): ApiWeatherData
}