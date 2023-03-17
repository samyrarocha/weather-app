package com.samyrarocha.core.data

import com.samyrarocha.core.data.mappers.toModel
import com.samyrarocha.core.domain.repository.WeatherRepository
import com.samyrarocha.core.domain.models.Weather
import com.samyrarocha.core.network.WeatherAppService
import javax.inject.Inject

const val DAILY_OPTIONS = "temperature_2m_max,temperature_2m_min,sunrise,precipitation_sum"
const val TIMEZONE = "GMT"

class WeatherRepositoryImp @Inject constructor(
    private val service: WeatherAppService
) : WeatherRepository {
    override suspend fun getWeatherData(latitude: Double, longitude: Double): Result<Weather> {
        return try {
            val data = service.getWeatherData(
                latitude = latitude,
                longitude = longitude,
                daily = DAILY_OPTIONS,
                currentWeather = true,
                timezone = TIMEZONE
            ).toModel()
            Result.success(data)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}