package com.samyrarocha.core.network.models

import com.google.gson.annotations.SerializedName

data class ApiWeatherData(
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("timezone") val timezone: String,
    @SerializedName("current_weather") val currentWeather: ApiCurrentWeatherData,
    @SerializedName("daily") val daily: ApiDailyData
)