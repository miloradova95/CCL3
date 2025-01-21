package com.example.dreamdex.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dreamdex.models.CharacterEntity

@Dao
interface CharacterDao {
    @Insert
    suspend fun insert(character: CharacterEntity)

    @Query("SELECT * FROM dreamdex")
    suspend fun getAllFavorites(): List<CharacterEntity>

    @Query("DELETE FROM dreamdex WHERE id = :characterId")
    suspend fun delete(characterId: Int)
}