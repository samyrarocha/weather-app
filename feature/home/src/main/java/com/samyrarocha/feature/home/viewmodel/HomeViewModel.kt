package com.samyrarocha.feature.home.viewmodel

import android.Manifest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samyrarocha.core.domain.usecases.GetLocationUseCase
import com.samyrarocha.core.domain.usecases.GetWeatherInfoUseCase
import com.samyrarocha.feature.home.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWeatherInfoUseCase: GetWeatherInfoUseCase,
    private val getLocationUseCase: GetLocationUseCase
    ): ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state

    fun getCurrentLocation(activity: AppCompatActivity) {
        val locationPermissionProvider = activity.registerForActivityResult(
            ActivityResultContracts.RequestPermission()) { granted ->
            if (granted){
                viewModelScope.launch{
                    getLocationUseCase.invoke()
                }
            }
        }
        locationPermissionProvider.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
    }

    fun getWeather() {
        viewModelScope.launch {
            runCatching {
                _state.value.currentLocation?.let {
                    getWeatherInfoUseCase(it.latitude, it.longitude)
                }
            }
                .onSuccess {}
                .onFailure {}
        }
    }
}