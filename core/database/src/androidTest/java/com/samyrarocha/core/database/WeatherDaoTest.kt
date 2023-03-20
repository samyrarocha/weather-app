package com.samyrarocha.core.database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.samyrarocha.core.database.dao.WeatherDao
import com.samyrarocha.core.database.database.WeatherDatabase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WeatherDaoTest {

    private lateinit var weatherDao: WeatherDao
    private lateinit var weatherDatabase: WeatherDatabase

    @Before
    fun setupDatabase(){
        weatherDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            WeatherDatabase::class.java
        ).allowMainThreadQueries().build()

        weatherDao = weatherDatabase.weatherDao()
    }

    @After
    fun closeDatabase(){
        weatherDatabase.close()
    }

    @Test
    fun insertWeatherInfo_should_return_success() = runBlocking {
        //When
        weatherDao.insertFavoriteLocation(insertFavoriteLocation())

        //Then
        assert(weatherDao.getLocations().contains(insertFavoriteLocation()))
    }

    @Test
    fun getWeatherInfo_should_return_success() = runBlocking {
        //Given
        val favoriteLocation  = getFavoriteLocation()

        //When
        weatherDao.insertFavoriteLocation(insertFavoriteLocation())
        val result = weatherDao.getLocations()

        //Then
        assertEquals(favoriteLocation, result)
    }

    @Test
    fun deleteWeatherInfo_should_return_success() = runBlocking {
        //When
        weatherDao.insertFavoriteLocation(insertFavoriteLocation())
        weatherDao.deleteFavoriteLocation(insertFavoriteLocation())

        //Then
        assert(weatherDao.getLocations().isEmpty())
    }
}