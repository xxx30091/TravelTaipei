package com.example.traveltaipei.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryItem(
    val name: String = "",
    val id: Int = 0
) : Parcelable