package com.samboy.map.retro

import com.samboy.map.models.Success
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Sam Raju on 5/1/21.
 */
interface ApiServices {

    @FormUrlEncoded
    @POST("msDiscoverPage")
    suspend fun getLocations(@Field("apiKey")apiKey:String,
                             @Field("searchText")search:String):Response<Success>
}