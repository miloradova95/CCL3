package com.example.dreamdex.models

data class Details(
    val mal_id: Int = 0,
    val name: String = "",
    val about: String = "",
    val anime: List<String> = emptyList(),
    val manga: List<String> = emptyList(),
    val image_url: String = "",
    val rating: String = ""
)
