package com.samyrarocha.core.network.models

import com.google.gson.annotations.SerializedName

data class ApiDailyData(
    @SerializedName("time") val time: List<String>,
    @SerializedName("temperature_2m_max") val temperatureMax: List<Float>,
    @SerializedName("temperature_2m_min") val temperatureMin: List<Float>,
    @SerializedName("sunrise") val sunrise: List<String>,
    @SerializedName("precipitation_sum") val precipitation: List<Float>,
    @SerializedName("sunset") val sunset: List<String>,
    @SerializedName("uv_index_max") val uvIndex: List<Float>,
)