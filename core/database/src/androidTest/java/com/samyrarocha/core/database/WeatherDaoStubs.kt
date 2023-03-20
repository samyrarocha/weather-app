package com.samyrarocha.core.database

import com.samyrarocha.core.database.entity.WeatherDataEntity

fun getFavoriteLocation() = listOf(
    WeatherDataEntity(
        id = 1,
        latitude = 23.5,
        longitude = 34.5
    )
)

fun insertFavoriteLocation() = WeatherDataEntity(
    id = 1,
    latitude = 23.5,
    longitude = 34.5
)