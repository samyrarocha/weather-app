package com.samyrarocha.core.data.mappers

import com.google.android.gms.maps.model.LatLng
import com.samyrarocha.core.database.entity.Location
import com.samyrarocha.core.domain.models.*
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
    precipitation = this.precipitation,
    sunset = this.sunset,
    uvIndex = this.uvIndex
)

fun Location.toModel() = FavoriteLocations(
    id = this.id,
    latitude = this.latitude,
    longitude = this.longitude
)

fun FavoriteLocations.toDatabase() = Location(
    id = this.id,
    latitude = this.latitude,
    longitude = this.longitude
)

fun LatLng.toModel() = CurrentLocation(
    latitude = this.latitude,
    longitude = this.longitude
)
