package com.example.traveltaipei.network.api

import com.example.traveltaipei.network.model.APIResponse
import com.example.traveltaipei.network.model.AttractionItem
import com.example.traveltaipei.network.model.ThemeItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

const val BASE_URL = "https://www.travel.taipei/open-api/"
var lang: String = ""

interface TripApi {

    @GET("{lang}/Attractions/All")
    suspend fun getAttractionsAll(
        @Header("Accept") accept: String? = "application/json",
        @Path("lang") lang: String
    ) :  Response<AttractionResponse>

//    @GET("{lang}/Tours/APIResponse")
//    suspend fun getTourTheme(
//        lang: String
//    ) : Response<APIResponse<ThemeItem>>

//    @GET("123")
//    fun getData(): Call<ResponseBody?>?

}