package com.example.dreamdex.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Delete
import com.example.dreamdex.db.FavoriteCharacter

@Dao
interface FavoriteCharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(character: FavoriteCharacter)

    @Delete
    suspend fun removeFavorite(character: FavoriteCharacter)

    @Query("SELECT * FROM favorites")
    suspend fun getAllFavorites(): List<FavoriteCharacter>

    @Query("SELECT * FROM favorites WHERE id = :id LIMIT 1")
    suspend fun isFavorite(id: Int): FavoriteCharacter?
}
