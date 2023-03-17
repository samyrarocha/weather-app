package com.samyrarocha.core.data

import android.accounts.NetworkErrorException
import com.samyrarocha.core.network.WeatherAppService
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

internal class WeatherRepositoryImpTest{

    private lateinit var weatherRepositoryImp: WeatherRepositoryImp
    private val fakeApi = mockk<WeatherAppService>(relaxed = true)

    @Before
    fun setupRepository(){
        weatherRepositoryImp = WeatherRepositoryImp(fakeApi)
    }

    @Test
    fun repository_should_return_success() = runBlocking{
        //Given
        val latitude = 52.52
        val longitude = 13.419
        val daily = "temperature_2m_max,temperature_2m_min,sunrise,precipitation_sum"
        val timeZone = "GMT"
        val currentWeather = true
        coEvery {
            fakeApi.getWeatherData(latitude, longitude, daily, currentWeather, timeZone)
        } returns getApiWeatherData()

        //When
        val result = weatherRepositoryImp.getWeatherData(latitude, longitude)

        //Then
        assertEquals(Result.success(getWeather()), result)
    }

    @Test
    fun repository_should_return_failure() = runBlocking{
        //Given
        val exception = NetworkErrorException()
        val latitude = 52.52
        val longitude = 13.419
        val daily = "temperature_2m_max,temperature_2m_min,sunrise,precipitation_sum"
        val timeZone = "GMT"
        val currentWeather = true
        coEvery {
            fakeApi.getWeatherData(latitude, longitude, daily, currentWeather, timeZone)
        } throws exception

        //When
        val result = weatherRepositoryImp.getWeatherData(latitude, longitude)
        val expected = Result.failure<NetworkErrorException>(exception)

        //Then
        assertEquals(expected , result)
    }
}