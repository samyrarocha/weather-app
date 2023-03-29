package com.samyrarocha.core.data

import com.samyrarocha.core.data.mappers.toDatabase
import com.samyrarocha.core.data.mappers.toModel
import com.samyrarocha.core.database.dao.WeatherDao
import com.samyrarocha.core.domain.models.CurrentLocation
import com.samyrarocha.core.domain.models.FavoriteLocations
import com.samyrarocha.core.domain.repository.WeatherRepository
import com.samyrarocha.core.domain.models.Weather
import com.samyrarocha.core.network.WeatherAppService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

const val DAILY_OPTIONS = "temperature_2m_max,temperature_2m_min,sunrise,precipitation_sum"
const val TIMEZONE = "GMT"

class WeatherRepositoryImp @Inject constructor(
    private val service: WeatherAppService,
    private val cache: WeatherDao,
    private val locationManager: LocationManager
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

    override suspend fun getFavoriteLocation(): List<FavoriteLocations> {
        return cache.getLocations().map { it.toModel() }
    }

    override suspend fun insertFavoriteLocation(favoriteLocations: FavoriteLocations) {
        cache.insertFavoriteLocation(favoriteLocations.toDatabase())
    }

    override suspend fun deleteFavoriteLocation(favoriteLocations: FavoriteLocations) {
        cache.deleteFavoriteLocation(favoriteLocations.toDatabase())
    }

    override suspend fun getCurrentLocation(): Flow<CurrentLocation> {
        return locationManager.getUserLocation().map { it.toModel() }
    }
}