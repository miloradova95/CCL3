package com.example.dreamdex.domain

import com.example.dreamdex.models.CharactersList
import com.example.dreamdex.models.Data
import com.example.dreamdex.models.GraphQLQuery
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("graphql") // Adjust endpoint if necessary
    suspend fun getCharactersList(
        @Body query: GraphQLQuery
    ): Response<CharactersList>

    @POST("graphql")
    suspend fun getCharacterDetails(
        @Body query: GraphQLQuery
    ): Response<Data>
}
