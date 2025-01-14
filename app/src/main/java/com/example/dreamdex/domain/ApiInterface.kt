package com.example.dreamdex.domain

import com.example.dreamdex.models.CharactersList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("characters?")
    suspend fun getCharacters(
        @Query("page") page: Int
    ): Response<CharactersList>
}