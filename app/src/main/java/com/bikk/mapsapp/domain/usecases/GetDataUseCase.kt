package com.bikk.mapsapp.domain.usecases

import com.bikk.mapsapp.domain.models.Place
import com.bikk.mapsapp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetDataUseCase(private val repository: Repository) : OutputUseCase<Flow<List<Place>>> {
    override fun getData(): Flow<List<Place>> = repository.getData()
}