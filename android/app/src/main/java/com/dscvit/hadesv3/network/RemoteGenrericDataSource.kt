package com.dscvit.hadesv3.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RemoteGenrericDataSource {
    companion object {
        const val BASE_URL = "https://hades3.herokuapp.com/"
    }

    // api interface class must be given as arg and it returns apiInstance of type given api
    fun <T> getAPIInstance(apiInterface: Class<T>): T {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(apiInterface)
    }
}