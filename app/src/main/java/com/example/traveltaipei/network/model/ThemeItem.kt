package com.example.traveltaipei.network.model

data class ThemeItem(
    val note: String = "",
    val seasons: List<String>?,
    val months: List<String>?,
    val author: String = "",
    val description: String = "",
    val consume: String = "",
    val remark: String = "",
//    val transport: Null = null,
    val title: String = "",
    val url: String = "",
//    val users: Null = null,
    val days: Int = 0,
    val modified: String = "",
    val id: Int = 0,
//    val category: Null = null
)