package com.samyrarocha.core.domain.usecases

import com.samyrarocha.core.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherInfoUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(latitude: Double, longitude: Double) =
        weatherRepository.getWeatherData(latitude, longitude)
}