package com.samboy.map.map.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.samboy.map.map.repository.MapRepository


/**
 * Created by Sam Raju on 5/1/21.
 */
class MapFactory(private val repository: MapRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MapViewModel::class.java)){
            return MapViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown map viewmodel class")
    }
}