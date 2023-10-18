package com.example.traveltaipei.network.api

import android.os.Parcelable
import com.example.traveltaipei.network.model.AttractionItem
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

//@JsonClass(generateAdapter = true)

data class AttractionResponse(
    val total: Int = 0,
    val data: List<AttractionItem>? = null,

//    @Json(name = "total") val total: Int = 0,
//    @Json(name = "data") val data: List<AttractionItem>? = null
)
