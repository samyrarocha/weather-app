package com.samyrarocha.core.data

import com.samyrarocha.core.domain.models.Weather
import com.samyrarocha.core.domain.models.CurrentWeather
import com.samyrarocha.core.domain.models.Daily
import com.samyrarocha.core.network.models.ApiCurrentWeatherData
import com.samyrarocha.core.network.models.ApiDailyData
import com.samyrarocha.core.network.models.ApiWeatherData

fun getApiWeatherData() = ApiWeatherData(
    latitude = 52.52,
    longitude = 13.419,
    timezone = "GMT",
    currentWeather = getApiCurrentWeatherData(),
    daily = getApiDailyData()
)

fun getApiCurrentWeatherData() = ApiCurrentWeatherData(
    temperature = 13.3F,
    windSpeed = 10.3F,
    windDirection = 262F,
    time = "2022-07-01T09:00",
    weatherCode = 1
)

fun getApiDailyData() = ApiDailyData(
    time = listOf(
        "2023-03-16",
        "2023-03-17",
        "2023-03-18",
        "2023-03-19",
        "2023-03-20",
        "2023-03-21",
        "2023-03-22"
    ),
    temperatureMax = listOf(
        8.9F,
        13.1F,
        12.7F,
        16.3F,
        10.5F,
        14.3F,
        17.4F
    ),
    temperatureMin = listOf(
        -1.0F,
        2.0F,
        5.4F,
        5.9F,
        7.3F,
        5.9F,
        9.0F
    ),
    sunrise = listOf(
        "2023-03-16T05:16",
        "2023-03-17T05:14",
        "2023-03-18T05:12",
        "2023-03-19T05:09",
        "2023-03-20T05:07",
        "2023-03-21T05:05",
        "2023-03-22T05:02"
    ),
    precipitation = listOf(
        0.00F,
        0.00F,
        0.10F,
        2.20F,
        0.00F,
        0.30F,
        0.30F
    ),
    sunset = listOf(
        "2023-03-16T05:16",
        "2023-03-17T05:14",
        "2023-03-18T05:12",
        "2023-03-19T05:09",
        "2023-03-20T05:07",
        "2023-03-21T05:05",
        "2023-03-22T05:02"
    ),
    uvIndex = listOf(
        0.00F,
        0.00F,
        0.10F,
        2.20F,
        0.00F,
        0.30F,
        0.30F
    )
)

fun getWeather() = Weather(
    latitude = 52.52,
    longitude = 13.419,
    timezone = "GMT",
    currentWeather = getCurrentWeather(),
    daily = getDaily()
)

fun getCurrentWeather() = CurrentWeather(
    temperature = 13.3F,
    windSpeed = 10.3F,
    windDirection = 262F,
    time = "2022-07-01T09:00",
    weatherCode = 1
)

fun getDaily() = Daily(
    time = listOf(
        "2023-03-16",
        "2023-03-17",
        "2023-03-18",
        "2023-03-19",
        "2023-03-20",
        "2023-03-21",
        "2023-03-22"
    ),
    temperatureMax = listOf(
        8.9F,
        13.1F,
        12.7F,
        16.3F,
        10.5F,
        14.3F,
        17.4F
    ),
    temperatureMin = listOf(
        -1.0F,
        2.0F,
        5.4F,
        5.9F,
        7.3F,
        5.9F,
        9.0F
    ),
    sunrise = listOf(
        "2023-03-16T05:16",
        "2023-03-17T05:14",
        "2023-03-18T05:12",
        "2023-03-19T05:09",
        "2023-03-20T05:07",
        "2023-03-21T05:05",
        "2023-03-22T05:02"
    ),
    precipitation = listOf(
        0.00F,
        0.00F,
        0.10F,
        2.20F,
        0.00F,
        0.30F,
        0.30F
    ),
    sunset = listOf(
        "2023-03-16T05:16",
        "2023-03-17T05:14",
        "2023-03-18T05:12",
        "2023-03-19T05:09",
        "2023-03-20T05:07",
        "2023-03-21T05:05",
        "2023-03-22T05:02"
    ),
    uvIndex = listOf(
        0.00F,
        0.00F,
        0.10F,
        2.20F,
        0.00F,
        0.30F,
        0.30F
    )
)