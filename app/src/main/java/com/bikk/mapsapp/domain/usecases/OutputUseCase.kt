package com.bikk.mapsapp.domain.usecases

interface OutputUseCase<T> {
    fun getData(): T
}