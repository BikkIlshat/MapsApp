package com.bikk.mapsapp.notes.adapter

import OnNotesClickListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bikk.mapsapp.R
import com.bikk.mapsapp.data.entities.NotesMakerEntity
import com.bikk.mapsapp.databinding.LayoutNotesMarkerListItemBinding



class NotesListAdapter(private val onNotesClickListener: OnNotesClickListener) :
    ListAdapter<NotesMakerEntity, NotesListAdapter.NotesViewHolder>(NotesMarkerDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder =
        NotesViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.layout_notes_marker_list_item, parent, false)
        )



    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener { onNotesClickListener.onClick(item) }
        holder.bind(item)

    }


    class NotesViewHolder(itemView: View, ) : RecyclerView.ViewHolder(itemView) {

        private val viewBinding: LayoutNotesMarkerListItemBinding by viewBinding()
        fun bind(notesMakerEntity: NotesMakerEntity) =
            with(viewBinding) {
                nameMarker.text = notesMakerEntity.nameMarker
                longitude.text = notesMakerEntity.longitude.toString()
                latitude.text = notesMakerEntity.latitude.toString()
                btnSaveDescribe.setOnClickListener {
                    Toast.makeText(itemView.context, "сохранение в доработке", Toast.LENGTH_SHORT).show() }
            }
    }


}


