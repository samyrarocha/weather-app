package com.samyrarocha.core.domain.usecases

import com.samyrarocha.core.domain.models.CurrentLocation
import com.samyrarocha.core.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocationUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend fun invoke(): Flow<CurrentLocation>{
        return repository.getCurrentLocation()
    }
}