package com.samyrarocha.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherDataEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val latitude:Double,
    val longitude: Double
)