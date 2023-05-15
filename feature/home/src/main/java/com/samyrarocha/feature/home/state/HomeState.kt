package com.samyrarocha.feature.home.state

import com.samyrarocha.core.domain.models.CurrentLocation
import com.samyrarocha.core.domain.models.CurrentWeather

data class HomeState (
    val currentWeather: CurrentWeather? = null,
    val currentLocation: CurrentLocation? = null
)