package com.bikk.mapsapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bikk.mapsapp.databinding.FragmentMapsBinding

class MapsFragment : Fragment(R.layout.fragment_maps) {

    private val viewBinding: FragmentMapsBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigate()
    }

    private fun navigate() {
       viewBinding.clickMy.setOnClickListener {
           findNavController().navigate(R.id.action_mapsFragment_to_notesFragment)
       }
    }


}