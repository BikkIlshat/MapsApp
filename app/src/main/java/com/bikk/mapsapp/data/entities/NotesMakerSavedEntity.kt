package com.bikk.mapsapp.data.entities

import androidx.room.*
import com.bikk.mapsapp.data.RoomConstants


@Entity(tableName = RoomConstants.FRAGMENT_NOTES_MARKER_TABLE)
data class NotesMakerSavedEntity(
    @PrimaryKey
    @ColumnInfo(name = "name marker")
    val nameMarker: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "title food")
    val latitude: Double,

    @ColumnInfo(name = "sourceName food")
    val longitude: Double,

)


