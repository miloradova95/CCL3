package com.example.dreamdex.db

import com.example.dreamdex.db.FavoriteCharacter

class FavoritesRepository(private val dao: FavoriteCharacterDao) {
    suspend fun addFavorite(character: FavoriteCharacter) = dao.addFavorite(character)
    suspend fun removeFavorite(character: FavoriteCharacter) = dao.removeFavorite(character)
    suspend fun getAllFavorites() = dao.getAllFavorites()
    suspend fun isFavorite(id: Int) = dao.isFavorite(id)
}