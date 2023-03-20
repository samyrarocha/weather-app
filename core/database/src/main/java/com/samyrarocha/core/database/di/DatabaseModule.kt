package com.samyrarocha.core.database.di

import android.content.Context
import androidx.room.Room
import com.samyrarocha.core.database.dao.WeatherDao
import com.samyrarocha.core.database.database.WeatherDatabase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModule {

    @Singleton
    fun provideDatabase(context: Context): WeatherDatabase {
        return Room.databaseBuilder(
            context,
            WeatherDatabase::class.java,
            "weather.db"
        )
            .build()
    }

    @Singleton
    fun provideMoviesDao(
        weatherDatabase: WeatherDatabase
    ): WeatherDao = weatherDatabase.weatherDao()
}