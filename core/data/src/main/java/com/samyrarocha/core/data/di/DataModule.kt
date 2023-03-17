package com.samyrarocha.core.data.di

import com.samyrarocha.core.data.WeatherRepositoryImp
import com.samyrarocha.core.domain.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun binsWeatherRepository(
        weatherRepositoryImp: WeatherRepositoryImp
    ): WeatherRepository
}