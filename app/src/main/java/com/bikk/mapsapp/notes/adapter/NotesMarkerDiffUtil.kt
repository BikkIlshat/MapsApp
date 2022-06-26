package com.bikk.mapsapp.notes.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bikk.mapsapp.data.entities.NotesMakerEntity


class NotesMarkerDiffUtil(
) : DiffUtil.ItemCallback<NotesMakerEntity>() {
    override fun areItemsTheSame(
        oldItem: NotesMakerEntity,
        newItem: NotesMakerEntity
    ) = oldItem === newItem

    override fun areContentsTheSame(
        oldItem: NotesMakerEntity,
        newItem: NotesMakerEntity
    ) = oldItem == newItem
}