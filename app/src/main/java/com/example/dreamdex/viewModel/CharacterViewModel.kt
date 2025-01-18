package com.example.dreamdex.viewModel

import android.telecom.Call.Details
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
    var id by mutableIntStateOf(0)

    init {
        viewModelScope.launch {
            val response = repository.getCharactersList(state.page, 50)
            if (response.isSuccessful) {
                val characters = response.body()?.data?.Page?.characters ?: emptyList()
                state = state.copy(
                    characters = characters
                )
            }
        }
    }

    fun getCharacterDetails(id: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getCharacterDetails(id)
                if (response.isSuccessful) {
                    response.body()?.let { characterDetails ->
                        state = state.copy(detailsData = characterDetails)
                    }
                } else {
                    // Handle API error (e.g., log it or show an error message)
                }
            } catch (e: Exception) {
                // Handle exceptions (e.g., network errors)
            }
        }
    }


}

data class ScreenState(
    val characters: List<Data> = emptyList(),
    val page: Int = 10,
    val detailsData: Data? = null
)