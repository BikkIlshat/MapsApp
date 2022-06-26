package com.bikk.mapsapp.di.modules

import com.bikk.mapsapp.application.App
import com.bikk.mapsapp.data.entities.NotesMakerEntity

class RoomModule : RoomModuleInt {
    override fun insertNotesMarker(notesMakerEntity: NotesMakerEntity) {
        App.instance.databaseService.getNotesMarkers().insertNotesMarker(notesMakerEntity)
    }

    override fun getNotesMarker(): List <NotesMakerEntity> {
        return App.instance.databaseService.getNotesMarkers().getNotesMarker()
    }
}