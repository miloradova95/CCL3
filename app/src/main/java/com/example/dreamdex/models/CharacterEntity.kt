package com.example.dreamdex.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dreamdex")
data class CharacterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String,
    val description: String
)
