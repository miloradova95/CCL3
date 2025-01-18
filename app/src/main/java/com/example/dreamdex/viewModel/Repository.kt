package com.example.dreamdex.viewModel

import com.example.dreamdex.domain.ApiInterface
import com.example.dreamdex.models.CharactersList
import com.example.dreamdex.models.Data
import com.example.dreamdex.models.GraphQLQuery
import com.example.dreamdex.utils.RetrofitInstance
import retrofit2.Response

class Repository {

    private val apiService: ApiInterface = RetrofitInstance.api

    suspend fun getCharactersList(page: Int, perPage: Int): Response<CharactersList> {
        // Construct the GraphQL query as a string
        val query = """
            query {
                Page(page: $page, perPage: $perPage) {
                    characters {
                        id
                        name {
                            full
                        }
                        image {
                            large
                        }
                        description
                    }
                    pageInfo {
                        currentPage
                        lastPage
                        hasNextPage
                        perPage
                    }
                }
            }
        """.trimIndent()

        // Wrap the query string in a GraphQLQuery object
        val graphqlQuery = GraphQLQuery(query)

        // Make the API call
        return apiService.getCharactersList(graphqlQuery)
    }

    suspend fun getCharacterDetails(id: Int): Response<Data> {
        val query = """
            query (${'$'}id: Int!) {
                Character(id: ${'$'}id) {
                    id
                    name {
                        full
                        native
                    }
                    description
                    image {
                        large
                        medium
                    }
                    media {
                        nodes {
                            id
                            title {
                                romaji
                                english
                                native
                            }
                            type
                        }
                    }
                }
            }
        """.trimIndent()

        val graphqlQuery = GraphQLQuery(query, variables = mapOf("id" to id))
        return apiService.getCharacterDetails(graphqlQuery)
    }
}