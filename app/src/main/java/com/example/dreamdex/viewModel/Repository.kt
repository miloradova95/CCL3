package com.example.dreamdex.viewModel

import com.example.dreamdex.models.CharactersList
import com.example.dreamdex.utils.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getCharactersList(page: Int) : Response<CharactersList> {
        return RetrofitInstance.api.getCharacters(page)
    }
}