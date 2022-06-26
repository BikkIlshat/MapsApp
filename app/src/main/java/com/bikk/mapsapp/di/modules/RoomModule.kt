package com.bikk.mapsapp.di.modules

import com.bikk.mapsapp.application.App
import com.bikk.mapsapp.data.entities.NotesMakerEntity

class RoomModule : RoomModuleInt{
   override fun insertNotesMarker(notesMaker: NotesMakerEntity) {
        App.instance.databaseService.getNotesMarkers().insertNotesMarker(notesMaker)
    }
}