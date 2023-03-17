package com.samyrarocha.core.network.di

import com.samyrarocha.core.network.WeatherAppService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun networkProvider(): WeatherAppService {
        return Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com")
            .build()
            .create(WeatherAppService::class.java)

    }
}