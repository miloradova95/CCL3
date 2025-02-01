package com.example.dreamdex.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.dreamdex.db.AppDatabase
import com.example.dreamdex.db.FavoritesRepository
import com.example.dreamdex.db.FavoriteCharacter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharactersViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FavoritesRepository

    private val _favorites = MutableStateFlow<List<FavoriteCharacter>>(emptyList())
    val favorites: StateFlow<List<FavoriteCharacter>> = _favorites

    init {
        val dao = AppDatabase.getInstance(application).favoriteCharacterDao()
        repository = FavoritesRepository(dao)
        fetchFavorites()
    }

    private fun fetchFavorites() {
        viewModelScope.launch {
            _favorites.value = repository.getAllFavorites()
        }
    }

    fun addFavorite(character: FavoriteCharacter) {
        viewModelScope.launch {
            repository.addFavorite(character)
            fetchFavorites()
        }
    }

    fun removeFavorite(character: FavoriteCharacter) {
        viewModelScope.launch {
            repository.removeFavorite(character)
            fetchFavorites()
        }
    }

    fun isFavorite(id: Int, callback: (Boolean) -> Unit) {
        viewModelScope.launch {
            val isFav = repository.isFavorite(id) != null
            callback(isFav)
        }
    }
}