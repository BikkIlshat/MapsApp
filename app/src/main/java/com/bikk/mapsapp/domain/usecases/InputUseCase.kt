package com.bikk.mapsapp.domain.usecases

interface InputUseCase<T> {
    suspend fun saveData(data: T)
    suspend fun update(data: T)
    suspend fun delete(data: T)
}