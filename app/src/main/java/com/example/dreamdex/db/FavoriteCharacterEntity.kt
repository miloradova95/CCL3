package com.example.dreamdex.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dreamdex.models.Title

@Entity(tableName = "favorites")
data class FavoriteCharacter(
    @PrimaryKey val id: Int,
    val name: String,
    val image: String,
    val description: String?,
    val title: String
)

