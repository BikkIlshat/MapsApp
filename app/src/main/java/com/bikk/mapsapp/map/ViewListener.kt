package com.bikk.mapsapp.map

import com.bikk.mapsapp.domain.models.Place

interface ViewListener {
    fun saveData(place: Place)
}