package com.example.dreamdex.viewModel

import android.content.Context
import com.example.dreamdex.models.CharacterDatabase
import com.example.dreamdex.models.CharacterEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DreamDexRepository(context: Context) {
    private val characterDao = CharacterDatabase.getDatabase(context).characterDao()

    suspend fun addCharacterToDreamDex(character: CharacterEntity) {
        withContext(Dispatchers.IO) {
            characterDao.insert(character)
        }
    }

    suspend fun getAllFavorites(): List<CharacterEntity> {
        return withContext(Dispatchers.IO) {
            characterDao.getAllFavorites()
        }
    }

    suspend fun removeCharacterFromDreamDex(characterId: Int) {
        withContext(Dispatchers.IO) {
            characterDao.delete(characterId)
        }
    }
}
