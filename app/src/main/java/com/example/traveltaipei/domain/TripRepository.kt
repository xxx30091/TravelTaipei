package com.example.traveltaipei.domain

import com.example.traveltaipei.network.api.TripApi
import retrofit2.Retrofit

class TripRepository(retrofit: Retrofit) {

    private val service = retrofit.create(TripApi::class.java)

    suspend fun getAttractionsAll(lang: String) = service.getAttractionsAll(lang = lang)

//    suspend fun getTourTheme(lang: String) = service.getTourTheme(lang)


}