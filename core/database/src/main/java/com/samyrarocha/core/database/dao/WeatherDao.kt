package com.samyrarocha.core.database.dao

import androidx.room.*
import com.samyrarocha.core.database.entity.Location

@Dao
interface WeatherDao {

    @Query("SELECT * FROM location")
    suspend fun getLocations(): List<Location>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteLocation(weatherData: Location)

    @Delete
    suspend fun deleteFavoriteLocation(weatherData: Location)
}