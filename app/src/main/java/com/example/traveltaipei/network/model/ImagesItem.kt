package com.example.traveltaipei.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImagesItem(
    val ext: String = "",
    val src: String = "",
    val subject: String = ""
) : Parcelable