package com.bikk.mapsapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bikk.mapsapp.data.dao.NotesMarkerSavedDao
import com.bikk.mapsapp.data.dao.NotesMarkersDao
import com.bikk.mapsapp.data.entities.NotesMakerEntity
import com.bikk.mapsapp.data.entities.NotesMakerSavedEntity


@Database(
    entities = [
        NotesMakerEntity::class,
        NotesMakerSavedEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {
    abstract fun getNotesMarkers(): NotesMarkersDao
    abstract fun getNotesMarkersSaved(): NotesMarkerSavedDao


    companion object {
        @Volatile
        private var INSTANCE: com.bikk.mapsapp.data.Database? = null

        fun createDatabase(context: Context): com.bikk.mapsapp.data.Database =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                com.bikk.mapsapp.data.Database::class.java,
                RoomConstants.DATABASE_NAME
            ).build()
    }
}
