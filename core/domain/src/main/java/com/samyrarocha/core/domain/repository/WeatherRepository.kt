package com.samyrarocha.core.domain.repository

import com.samyrarocha.core.domain.models.CurrentLocation
import com.samyrarocha.core.domain.models.FavoriteLocations
import com.samyrarocha.core.domain.models.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeatherData(latitude: Double, longitude: Double): Result<Weather>
    suspend fun getFavoriteLocation(): List<FavoriteLocations>
    suspend fun insertFavoriteLocation(favoriteLocations: FavoriteLocations)
    suspend fun deleteFavoriteLocation(favoriteLocations: FavoriteLocations)
    suspend fun getCurrentLocation(): Flow<CurrentLocation>
}