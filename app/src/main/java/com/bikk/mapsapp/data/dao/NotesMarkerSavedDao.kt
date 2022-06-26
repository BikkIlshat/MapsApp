package com.bikk.mapsapp.data.dao

import androidx.room.*
import com.bikk.mapsapp.data.RoomConstants
import com.bikk.mapsapp.data.entities.NotesMakerEntity
@Dao
interface NotesMarkerSavedDao {

        @Query("SELECT * FROM ${RoomConstants.FRAGMENT_NOTES_MARKER_TABLE}")
        fun getNotesMarker(): NotesMakerEntity

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertNotesMarker(notesMakerEntity: NotesMakerEntity)

        @Delete
        fun deleteNotesMarker(notesMakerEntity: List<NotesMakerEntity>)

        @Query("DELETE FROM ${RoomConstants.FRAGMENT_NOTES_MARKER_TABLE}")
        fun deleteAllNotesMarker()

}