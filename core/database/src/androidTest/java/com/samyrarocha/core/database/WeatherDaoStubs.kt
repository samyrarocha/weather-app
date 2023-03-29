package com.samyrarocha.core.database

import com.samyrarocha.core.database.entity.Location

fun getFavoriteLocation() = listOf(
    Location(
        id = 1,
        latitude = 23.5,
        longitude = 34.5
    )
)

fun insertFavoriteLocation() = Location(
    id = 1,
    latitude = 23.5,
    longitude = 34.5
)