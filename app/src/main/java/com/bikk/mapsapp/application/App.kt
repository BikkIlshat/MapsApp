package com.bikk.mapsapp.application

import android.app.Application
import com.bikk.mapsapp.data.Database


class App : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    init {
        instance = this
    }

    val databaseService: Database by lazy { Database.createDatabase(applicationContext) }


    companion object {
        lateinit var instance: App
            private set
    }
}
