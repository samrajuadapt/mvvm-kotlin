package com.samboy.map.retro

import com.samboy.map.utils.SC
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Sam Raju on 5/1/21.
 */
class RetroClient {
    companion object{
         fun apiService():ApiServices{
            val retro = Retrofit.Builder()
                .baseUrl(SC.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
             return retro.create(ApiServices::class.java)
        }

        private fun header(username: String,password: String): OkHttpClient {
            val httpClient = OkHttpClient.Builder()

            httpClient.addInterceptor{
                val credentials = Credentials.basic(username,password)
                val orginal  = it.request()
                val request = orginal.newBuilder()
                    .header("",credentials)
                    .method(orginal.method(),orginal.body())
                    .build()
                it.proceed(request)

            }
            return httpClient.build()
        }
    }
}