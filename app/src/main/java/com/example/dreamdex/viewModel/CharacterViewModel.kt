package com.example.dreamdex.viewModel

import androidx.compose.runtime.getValue
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
        viewModelScope.launch {
            val response = repository.getCharactersList(state.page)
            state = state.copy(
                characters = response.body()!!.data
            )
        }
    }


}

data class ScreenState(
    val characters: List<Data> = emptyList(),
    val page: Int = 1
)