package com.bikk.mapsapp.data.dao

import androidx.room.*
import com.bikk.mapsapp.data.RoomConstants.NOTES_SAVED_MARKERS_TABLE
import com.bikk.mapsapp.data.entities.NotesMakerEntity


@Dao
interface NotesMarkersDao {
    @Query("SELECT * FROM $NOTES_SAVED_MARKERS_TABLE")
    fun getNotesMarker(): NotesMakerEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotesMarker(notesMakerEntity: NotesMakerEntity)

    @Delete
    fun deleteNotesMarker(notesMakerEntity: List<NotesMakerEntity>)

    @Query("DELETE FROM $NOTES_SAVED_MARKERS_TABLE")
    fun deleteAllNotesMarker()

}