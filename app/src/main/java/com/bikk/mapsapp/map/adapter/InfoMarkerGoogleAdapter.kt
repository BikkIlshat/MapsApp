package com.bikk.mapsapp.map.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.bikk.mapsapp.databinding.MarkerInfoLayoutBinding
import com.bikk.mapsapp.domain.models.Place
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class InfoMarkerGoogleAdapter(
    private val context: Context
) : GoogleMap.InfoWindowAdapter {
    private var viewBinding: MarkerInfoLayoutBinding? = null
    override fun getInfoContents(marker: Marker): View? {
        val place = marker.tag as? Place?
        viewBinding = MarkerInfoLayoutBinding.inflate(LayoutInflater.from(context))
        viewBinding?.titleTextview?.text = place?.name
        viewBinding?.adressTextview?.text = place?.address
        viewBinding?.ratingTextview?.text = "Rating: ${place?.rating.toString()}"
        return viewBinding?.root
    }

    override fun getInfoWindow(marker: Marker): View? {
        val place = marker.tag as? Place?
        viewBinding = MarkerInfoLayoutBinding.inflate(LayoutInflater.from(context))
        viewBinding?.titleTextview?.text = place?.name
        viewBinding?.adressTextview?.text = place?.address
        viewBinding?.ratingTextview?.text = "Rating: ${place?.rating.toString()}"
        return viewBinding?.root
    }
}