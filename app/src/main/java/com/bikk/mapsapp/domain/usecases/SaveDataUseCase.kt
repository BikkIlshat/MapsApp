package com.bikk.mapsapp.domain.usecases

import com.bikk.mapsapp.domain.models.Place
import com.bikk.mapsapp.domain.repository.Repository

class SaveDataUseCase(private val repository: Repository) : InputUseCase<Place> {
    override suspend fun saveData(data: Place) = repository.saveData(data)
    override suspend fun update(data: Place) = repository.update(data)
    override suspend fun delete(data: Place) = repository.delete(data)
}