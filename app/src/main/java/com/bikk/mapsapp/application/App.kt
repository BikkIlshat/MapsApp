package com.bikk.mapsapp.application

import android.app.Application
import com.bikk.mapsapp.data.Database
import com.bikk.mapsapp.di.DI
import org.koin.core.context.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(DI.mainModule)
        }
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
