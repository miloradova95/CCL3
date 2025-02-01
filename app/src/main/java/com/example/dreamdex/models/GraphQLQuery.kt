package com.example.dreamdex.models

data class GraphQLQuery(
    val query: String,
    val variables: Map<String, Any>? = null
)
