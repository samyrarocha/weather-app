package com.samyrarocha.core.data.mappers

import com.samyrarocha.core.domain.models.CurrentWeather
import com.samyrarocha.core.domain.models.Daily
import com.samyrarocha.core.domain.models.Weather
import com.samyrarocha.core.network.models.ApiCurrentWeatherData
import com.samyrarocha.core.network.models.ApiDailyData
import com.samyrarocha.core.network.models.ApiWeatherData
import javax.inject.Inject


class WeatherMapper @Inject constructor(
    private val currentWeatherMapper: CurrentWeatherMapper,
    private val dailyMapper: DailyMapper
): DomainMapper<ApiWeatherData, Weather> {
    override fun mapToDomain(apiEntity: ApiWeatherData): Weather {
        return Weather(
            latitude = apiEntity.latitude,
            longitude = apiEntity.longitude,
            timezone = apiEntity.timezone,
            currentWeather = currentWeatherMapper.mapToDomain(apiEntity.currentWeather),
            daily = dailyMapper.mapToDomain(apiEntity.daily)
        )
    }
}

class CurrentWeatherMapper: DomainMapper<ApiCurrentWeatherData, CurrentWeather>{
    override fun mapToDomain(apiEntity: ApiCurrentWeatherData): CurrentWeather {
        return CurrentWeather(
            temperature = apiEntity.temperature,
            windSpeed = apiEntity.windSpeed,
            windDirection = apiEntity.windDirection,
            weatherCode = apiEntity.weatherCode,
            time = apiEntity.time
        )
    }
}

class DailyMapper: DomainMapper<ApiDailyData, Daily>{
    override fun mapToDomain(apiEntity: ApiDailyData): Daily {
        return Daily(
            time = apiEntity.time,
            temperatureMax = apiEntity.temperatureMax,
            temperatureMin = apiEntity.temperatureMin,
            sunrise = apiEntity.sunrise,
            precipitation = apiEntity.precipitation
        )
    }
}