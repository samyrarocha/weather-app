package com.samyrarocha.core.domain.models

data class Daily(
    val time: List<String>,
    val temperatureMax: List<Float>,
    val temperatureMin: List<Float>,
    val sunrise: List<String>,
    val precipitation: List<Float>,
    val sunset: List<String>,
    val uvIndex: List<Float>
)
