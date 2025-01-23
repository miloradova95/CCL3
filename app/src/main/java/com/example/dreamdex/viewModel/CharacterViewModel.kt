package com.example.dreamdex.viewModel

import android.telecom.Call.Details
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dreamdex.models.CharactersList
import com.example.dreamdex.models.Data
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val repository = Repository()
    var state by mutableStateOf(ScreenState())


    init {
        fetchCharactersList()
    }

    private fun fetchCharactersList() {
        viewModelScope.launch {
            try {
                val response = repository.getCharactersList(state.page, 50)
                Log.e("hello", response.toString())
                if (response.isSuccessful) {
                    val characters = response.body()?.data?.Page?.characters ?: emptyList()
                    state = state.copy(characters = characters)
                } else {
                    // Handle API error (e.g., log or show an error message)
                }
            } catch (e: Exception) {
                Log.e("Error fetching CharactersList", e.toString())
                // Handle exceptions (e.g., network errors)
            }
        }
    }

    suspend fun getCharacterDetails(id: Int): Data?  {
            try {
                val response = repository.getCharacterDetails(id)
                if (response.isSuccessful) {
                    response.body()?.let { characterDetails ->
                        return characterDetails
                    }
                } else {
                    return null
                }
            } catch (e: Exception) {
                Log.e("Error fetching CharactersDetails", e.toString())
                return null
            }
        return null
    }

    fun loadMoreCharacters() {
        state = state.copy(page = state.page + 1)
        fetchCharactersList()
    }
}

data class ScreenState(
    val characters: List<Data> = emptyList(),
    val page: Int = 1,
    val detailsData: Data? = null // Nullable to avoid initialization issues
)
