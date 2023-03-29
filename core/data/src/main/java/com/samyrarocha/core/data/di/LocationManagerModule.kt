package com.samyrarocha.core.data.di

import android.content.Context
import com.samyrarocha.core.data.LocationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocationManagerModule {

    @Provides
    @Singleton
    fun provideLocationManager( @ApplicationContext context: Context): LocationManager =
        LocationManager(context)
}