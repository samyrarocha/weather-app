package com.samyrarocha.core.data

import com.samyrarocha.core.data.mappers.WeatherMapper
import com.samyrarocha.core.domain.WeatherRepository
import com.samyrarocha.core.domain.models.Weather
import com.samyrarocha.core.network.WeatherAppService
import javax.inject.Inject

const val DAILY_OPTIONS = "temperature_2m_max,temperature_2m_min,sunrise,precipitation_sum"
const val TIMEZONE = "GMT"

class WeatherRepositoryImp @Inject constructor(
    private val service: WeatherAppService,
    private val weatherMapper: WeatherMapper
) : WeatherRepository {
    override suspend fun getWeatherData(latitude: Double, longitude: Double): Weather {
        val weather = service.getWeatherData(
            latitude = latitude,
            longitude = longitude,
            daily = DAILY_OPTIONS,
            currentWeather = true,
            timezone = TIMEZONE
        )
        return weatherMapper.mapToDomain(weather)
    }
}