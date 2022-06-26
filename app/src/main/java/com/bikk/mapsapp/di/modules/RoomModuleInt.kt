package com.bikk.mapsapp.di.modules

import com.bikk.mapsapp.data.entities.NotesMakerEntity

interface RoomModuleInt {
    fun insertNotesMarker(notesMaker: NotesMakerEntity)
}