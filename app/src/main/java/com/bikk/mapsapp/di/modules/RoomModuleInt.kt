package com.bikk.mapsapp.di.modules

import com.bikk.mapsapp.data.entities.NotesMakerEntity
import com.bikk.mapsapp.data.entities.NotesMakerSavedEntity

interface RoomModuleInt {
    fun insertNotesMarker(notesMakerEntity: NotesMakerEntity)
    fun getNotesMarker(): List <NotesMakerEntity>
    fun insertSaveDescribeMarker(notesMakerSavedEntity: NotesMakerSavedEntity)

}