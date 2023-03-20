package com.samyrarocha.core.database.dao

import androidx.room.*
import com.samyrarocha.core.database.entity.WeatherDataEntity

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather")
    suspend fun getLocations(): List<WeatherDataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteLocation(weatherData: WeatherDataEntity)

    @Delete
    suspend fun deleteFavoriteLocation(weatherData: WeatherDataEntity)
}