package com.example.dreamdex.models

data class Metadata(
    val current_page: String,  // Current page number
    val page_count: Int,       // Total number of pages
    val per_page: Int,         // Number of items per page
    val total_count: Int       // Total number of items
)
