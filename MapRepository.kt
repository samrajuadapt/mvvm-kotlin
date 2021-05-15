package com.samboy.map.map.repository

import androidx.annotation.WorkerThread
import com.samboy.map.models.Success
import com.samboy.map.retro.RetroClient
import com.samboy.map.utils.SC
import retrofit2.Response

/**
 * Created by Sam Raju on 5/1/21.
 */
class MapRepository {

    val api by lazy {
        RetroClient.apiService()
    }

    suspend fun getLocation():Response<Success>{
        return api.getLocations(SC.API_KEY,"");
    }
}