package com.samyrarocha.core.network.models

import com.google.gson.annotations.SerializedName

data class ApiCurrentWeatherData(
    @SerializedName("temperature") val temperature: Float,
    @SerializedName("windspeed") val windSpeed: Float,
    @SerializedName("winddirection") val windDirection: Float,
    @SerializedName("weathercode") val weatherCode: Int,
    @SerializedName("time") val time: String
)
