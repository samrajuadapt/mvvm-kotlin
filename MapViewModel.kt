package com.samboy.map.map.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.samboy.map.map.repository.MapRepository
import com.samboy.map.models.Location
import com.samboy.map.models.Success
import com.samboy.map.utils.Coroutines
import com.samboy.map.utils.loge

/**
 * Created by Sam Raju on 5/1/21.
 */
class MapViewModel(private val repository: MapRepository): ViewModel() {

    var mLocations:MutableLiveData<List<Location>> = MutableLiveData();
    var isLoading:MutableLiveData<Boolean> = MutableLiveData()


    fun fetchLocations(){
        isLoading.value = true
        Coroutines.main {
            val response = repository.getLocation()
            if(response.isSuccessful){
                response.body()?.run {
                    if(!error){
                        isLoading.value = false
                        mLocations.value = locationData
                    }
                }
            }
        }
    }
}