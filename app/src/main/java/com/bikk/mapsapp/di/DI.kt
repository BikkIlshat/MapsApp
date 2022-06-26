package com.bikk.mapsapp.di

import com.bikk.mapsapp.di.modules.RoomModule
import com.bikk.mapsapp.di.modules.RoomModuleInt
import org.koin.dsl.module

object DI {
    val mainModule = module {
        single<RoomModuleInt> { RoomModule() }
    }
}