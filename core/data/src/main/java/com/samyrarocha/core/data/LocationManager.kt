package com.samyrarocha.core.data

import android.annotation.SuppressLint
import android.content.Context
import com.google.android.gms.location.*
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.*

@SuppressLint("MissingPermission")
class LocationManager(context: Context) {

    private val location = mutableListOf<LatLng>()

    private val fusedLocationClient by lazy {
        LocationServices.getFusedLocationProviderClient(context)
    }

    fun getUserLocation(): Flow<LatLng> {
        fusedLocationClient.lastLocation.addOnSuccessListener { _location ->
            val latLng = LatLng(_location.latitude, _location.longitude)
            location.add(latLng)
        }
        return location.asFlow()
    }
}