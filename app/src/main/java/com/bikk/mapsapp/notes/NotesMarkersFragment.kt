package com.bikk.mapsapp.notes

import OnNotesClickListener
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bikk.mapsapp.R
import com.bikk.mapsapp.data.entities.NotesMakerEntity
import com.bikk.mapsapp.databinding.FragmentNotesMarkerBinding
import com.bikk.mapsapp.notes.adapter.CategoryAdapter

class NotesMarkersFragment : Fragment(R.layout.fragment_notes_marker) {
    private val viewBinding: FragmentNotesMarkerBinding by viewBinding()
    private lateinit var adapter: CategoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() = with(viewBinding) {
        adapter = CategoryAdapter(object : OnNotesClickListener {
            override fun onClick(notesMarker: NotesMakerEntity) {
                navigateUP()
            }
        })
        categoryListRecyclerView.adapter = adapter
    }

    private fun navigateUP() {
        findNavController().navigateUp()
    }
}

