package com.samyrarocha.core.data.mappers

import com.samyrarocha.core.database.entity.WeatherDataEntity
import com.samyrarocha.core.domain.models.CurrentWeather
import com.samyrarocha.core.domain.models.Daily
import com.samyrarocha.core.domain.models.FavoriteLocations
import com.samyrarocha.core.domain.models.Weather
import com.samyrarocha.core.network.models.ApiCurrentWeatherData
import com.samyrarocha.core.network.models.ApiDailyData
import com.samyrarocha.core.network.models.ApiWeatherData

fun ApiWeatherData.toModel() = Weather(
        latitude = this.latitude,
        longitude = this.longitude,
        timezone = this.timezone,
        currentWeather = this.currentWeather.toModel(),
        daily = this.daily.toModel()
)

private fun ApiCurrentWeatherData.toModel() = CurrentWeather(
    temperature = this.temperature,
    windSpeed = this.windSpeed,
    windDirection = this.windDirection,
    weatherCode = this.weatherCode,
    time = this.time
)

private fun ApiDailyData.toModel() = Daily(
    time = this.time,
    temperatureMax = this.temperatureMax,
    temperatureMin = this.temperatureMin,
    sunrise = this.sunrise,
    precipitation = this.precipitation
)

fun WeatherDataEntity.toModel() = FavoriteLocations(
    id = this.id,
    latitude = this.latitude,
    longitude = this.longitude
)

fun FavoriteLocations.toDatabase() = WeatherDataEntity(
    id = this.id,
    latitude = this.latitude,
    longitude = this.longitude
)
