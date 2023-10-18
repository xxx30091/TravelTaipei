package com.example.traveltaipei.network.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

//data class APIResponse<T>(
//    @Json(name = "total") val total: Int = 0,
//    @Json(name = "data") val data: T?
//)

@Keep
data class APIResponse<T>(
    val code: Int,
    val message: String?,
    val data: T?
)