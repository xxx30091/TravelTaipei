package com.example.traveltaipei

import android.app.Application
import com.example.traveltaipei.domain.TripRepository
import com.example.traveltaipei.network.api.BASE_URL
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.properties.Delegates


class MyApplication : Application() {

    companion object {
        var instance: MyApplication by Delegates.notNull()

        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        private var gson = GsonBuilder()
            .setLenient()
            .create()

        private val client = OkHttpClient.Builder()
//            .newBuilder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()

        private val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .client(client)
            .build()

        val tripRepository = TripRepository(retrofit)

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}