package com.bikk.mapsapp.notes

import OnNotesClickListener
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bikk.mapsapp.R
import com.bikk.mapsapp.data.entities.NotesMakerEntity
import com.bikk.mapsapp.data.entities.NotesMakerSavedEntity
import com.bikk.mapsapp.databinding.FragmentNotesMarkerBinding
import com.bikk.mapsapp.di.modules.RoomModuleInt
import com.bikk.mapsapp.notes.adapter.NotesListAdapter
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject

class NotesMarkersFragment : Fragment(R.layout.fragment_notes_marker) {
    private val viewBinding: FragmentNotesMarkerBinding by viewBinding()
    private lateinit var adapter: NotesListAdapter
    val repo: RoomModuleInt by inject()
    private var listNotesBD = emptyList<NotesMakerEntity>()
    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable -> Log.d(tag, "throwable:$throwable") }
    private val scopeIo =
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler + SupervisorJob())
    private val scopeMain =
        CoroutineScope(Dispatchers.Main + coroutineExceptionHandler + SupervisorJob())
    private var job: Job? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        job = scopeMain.launch() {

            listNotesBD = withContext(Dispatchers.IO) {
                return@withContext repo.getNotesMarker()
            }

            adapter.submitList(listNotesBD)
        }
    }

    fun saveDescribeToDB(notesMarkerSavedEntity:NotesMakerSavedEntity){

        val savedEntity = NotesMakerSavedEntity(
            nameMarker =  notesMarkerSavedEntity.nameMarker,
            description = notesMarkerSavedEntity.description,
            latitude = notesMarkerSavedEntity.latitude,
            longitude = notesMarkerSavedEntity.longitude
        )
        scopeIo.launch { repo.insertSaveDescribeMarker(savedEntity) }
    }

    private fun initRecyclerView() = with(viewBinding) {
        adapter = NotesListAdapter(object : OnNotesClickListener {
            override fun onClick(notesMarker: NotesMakerEntity) {
                navigateToUp()
            }
        })
        categoryListRecyclerView.adapter = adapter

    }

    private fun navigateToUp() {
        findNavController().navigateUp()
    }
}
