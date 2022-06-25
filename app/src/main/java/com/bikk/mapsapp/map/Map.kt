package com.bikk.mapsapp.map

import androidx.annotation.IdRes
import com.bikk.mapsapp.domain.models.Place


interface Map {
    fun initUiSettings(@IdRes id: Int)
    fun addMarkers(placeData : List<Place>)
    fun initMyLocation()
    fun initListeners(placeData : List<Place>)
    fun onMapListener()
}