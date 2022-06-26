package com.bikk.mapsapp.data.entities

import androidx.room.*
import com.bikk.mapsapp.data.RoomConstants


@Entity(tableName = RoomConstants.NOTES_SAVED_MARKERS_TABLE)
data class NotesMakerEntity(

    @PrimaryKey
    @ColumnInfo(name = "name marker")
    val nameMarker: String,

    @ColumnInfo(name = "title food")
    val latitude: Double,

    @ColumnInfo(name = "sourceName food")
    val longitude: Double,

)


