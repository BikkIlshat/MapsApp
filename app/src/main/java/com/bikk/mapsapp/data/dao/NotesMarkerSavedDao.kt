package com.bikk.mapsapp.data.dao

import androidx.room.*
import com.bikk.mapsapp.data.RoomConstants
import com.bikk.mapsapp.data.entities.NotesMakerEntity
import com.bikk.mapsapp.data.entities.NotesMakerSavedEntity

@Dao
interface NotesMarkerSavedDao {

        @Query("SELECT * FROM ${RoomConstants.FRAGMENT_NOTES_MARKER_TABLE}")
        fun getNotesMarker(): NotesMakerSavedEntity

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertSaveDescribeMarker(notesMakerEntity: NotesMakerSavedEntity)

        @Delete
        fun deleteNotesMarker(notesMakerEntity: List<NotesMakerSavedEntity>)

        @Query("DELETE FROM ${RoomConstants.FRAGMENT_NOTES_MARKER_TABLE}")
        fun deleteAllNotesMarker()

}