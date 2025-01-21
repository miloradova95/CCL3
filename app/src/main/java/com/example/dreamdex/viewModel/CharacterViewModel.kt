package com.example.dreamdex.viewModel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dreamdex.models.CharacterEntity
import com.example.dreamdex.models.Data
import kotlinx.coroutines.launch

class CharacterViewModel(private val context: Context) : ViewModel() {

    private val dreamDexRepository = DreamDexRepository(context)
    var state by mutableStateOf(ScreenState())

    init {
        fetchCharactersList()
        getDreamDexFavorites() // Load favorites on ViewModel initialization
    }

    private fun fetchCharactersList() {
        viewModelScope.launch {
            try {
                val response = Repository().getCharactersList(state.page, 50)
                if (response.isSuccessful) {
                    val characters = response.body()?.data?.Page?.characters ?: emptyList()
                    state = state.copy(characters = characters)
                }
            } catch (e: Exception) {
                // Handle network exceptions
            }
        }
    }

    fun addCharacterToDreamDex(character: Data) {
        viewModelScope.launch {
            val characterEntity = CharacterEntity(
                id = character.id,
                name = character.name.full,
                imageUrl = character.image.large,
                description = character.description ?: ""
            )
            dreamDexRepository.addCharacterToDreamDex(characterEntity)
        }
    }

    fun removeCharacterFromDreamDex(characterId: Int) {
        viewModelScope.launch {
            dreamDexRepository.removeCharacterFromDreamDex(characterId)
        }
    }

    private fun getDreamDexFavorites() {
        viewModelScope.launch {
            val favorites = dreamDexRepository.getAllFavorites()
            state = state.copy(favorites = favorites)
        }
    }
}

data class ScreenState(
    val characters: List<Data> = emptyList(),
    val page: Int = 10,
    val favorites: List<CharacterEntity> = emptyList()  // Add this to store favorites
)
