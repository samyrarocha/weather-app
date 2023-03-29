package com.samyrarocha.core.database.di

import android.content.Context
import androidx.room.Room
import com.samyrarocha.core.database.dao.WeatherDao
import com.samyrarocha.core.database.database.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase( @ApplicationContext context: Context): WeatherDatabase {
        return Room.databaseBuilder(
            context,
            WeatherDatabase::class.java,
            "weather.db"
        )
            .build()
    }

    @Provides
    @Singleton
    fun provideMoviesDao(
        weatherDatabase: WeatherDatabase
    ): WeatherDao = weatherDatabase.weatherDao()
}