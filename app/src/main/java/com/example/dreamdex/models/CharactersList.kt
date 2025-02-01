package com.example.dreamdex.models

data class CharactersList(
    val data: CharacterData
)

data class CharacterData(
    val Page: Page
)

data class Page(
    val characters: List<Data>,
    val pageInfo: PageInfo
)

data class PageInfo(
    val currentPage: Int,
    val lastPage: Int,
    val hasNextPage: Boolean,
    val perPage: Int
)
