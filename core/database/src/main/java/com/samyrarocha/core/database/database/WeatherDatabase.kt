package com.samyrarocha.core.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.samyrarocha.core.database.dao.WeatherDao
import com.samyrarocha.core.database.entity.WeatherDataEntity

@Database(entities = [WeatherDataEntity::class], version = 1)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}