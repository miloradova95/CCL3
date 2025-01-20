package com.example.dreamdex.models

data class Data(
    val id: Int,
    val name: Name,
    val image: Image,
    val description: String?,
    val rating: String? = null,
    val media: MediaConnection,
    val gender: String?,
    val dateOfBirth: String?,
    val age: String?,
    val bloodType: String?
)

data class Name(
    val full: String,
    val native: String?
)

data class Image(
    val large: String,
    val medium: String
)

data class MediaConnection(
    val nodes: List<MediaNode>
)

data class MediaNode(
    val id: Int,
    val title: Title,
    val type: String // Anime or Manga
)

data class Title(
    val romaji: String,
    val english: String?,
    val native: String?
)
