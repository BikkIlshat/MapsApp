package com.bikk.mapsapp

import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bikk.mapsapp.databinding.FragmentMapsBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.*
import java.io.IOException

private const val REQUEST_CODE = 12345
private const val MIN_TIME_MS = 5000L
private const val MIN_DISTANCE_M = 10f

class MapsFragment : Fragment(R.layout.fragment_maps) {

    private val viewBinding: FragmentMapsBinding by viewBinding()
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, _ -> }
    private val scopeIo = CoroutineScope(Dispatchers.IO + coroutineExceptionHandler + SupervisorJob())
    private var job: Job? = null

    private val permissionResult = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { result ->
        if (result) {
            getLocation()
        } else {
            Toast.makeText(
                context, getString(R.string.need_permissions_to_find_location),
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    private val callback = OnMapReadyCallback { googleMap ->
        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        viewBinding.mainFragmentFABLocation.setOnClickListener { checkPermission() }
    }

    private fun checkPermission() {
        activity?.let {
            when (PackageManager.PERMISSION_GRANTED) {
                ContextCompat.checkSelfPermission(it, Manifest.permission.ACCESS_FINE_LOCATION) -> {
                    getLocation()
                }
                else -> {
                    permissionResult.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                }
            }
        }
    }

    // получаем текущее местоположение
    private fun getLocation() {
        val locationManager = // локация определяется через locationManager
            requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
// Проверка включено ли местоположенире
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            val provider = locationManager.getProviderProperties(LocationManager.GPS_PROVIDER)
            provider?.let {
                // Будем получать геоположение через каждые 60 секунд или каждые 100 метров
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    MIN_TIME_MS,
                    MIN_DISTANCE_M,
                    onLocationListener
                )
            }

        } else {
            val location =
                locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER) // запрос последнего известного местоположения в системе
            if (location == null) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.looks_like_location_disabled),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                getAddressAsync(location)
            }
        }
    }

    private val onLocationListener = LocationListener { location -> getAddressAsync(location) }


    //Тема геокодер
    private fun getAddressAsync(location: Location) = with(viewBinding) {
        val geoCoder = Geocoder(context)
        job = scopeIo.launch(Dispatchers.IO) {
            try {
                val addresses = geoCoder.getFromLocation(
                    location.latitude,
                    location.longitude,
                    1
                )
                withContext(Dispatchers.Main) {
                    showAddressDialog(addresses[0].getAddressLine(0), location)
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }


    private fun showAddressDialog(address: String, location: Location) {
        activity?.let {
            AlertDialog.Builder(it)
                .setTitle(getString(R.string.dialog_address_title))
                .setMessage(address)
                .setPositiveButton(getString(R.string.dialog_take_a_note)) { _, _ ->
//                    openDetailsFragment(
//                        Weather(
//                            City(
//                                address,
//                                location.latitude,
//                                location.longitude
//                            )
//                        )
//                    )
                }
                .setNegativeButton(getString(R.string.dialog_button_close)) { dialog, _ -> dialog.dismiss() }
                .create()
                .show()
        }
    }


    override fun onDestroy() {
        scopeIo.cancel()
        super.onDestroy()
    }
}