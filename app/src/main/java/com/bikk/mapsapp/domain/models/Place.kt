package com.bikk.mapsapp.domain.models

import com.google.android.gms.maps.model.LatLng

data class Place(
    val id: Int,
    val name: String,
    val latLng: LatLng,
    val address: String,
    val rating: Float
)
