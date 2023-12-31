package com.jeancorzo.rickandmorty.characters.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.jeancorzo.rickandmorty.characters.domain.model.Character
import com.jeancorzo.rickandmorty.characters.service.dto.CharacterListDto
import com.jeancorzo.rickandmorty.repository.ListRemoteMediator
import com.jeancorzo.rickandmorty.repository.PAGE_SIZE
import com.jeancorzo.rickandmorty.storage.db.AppDatabase
import com.jeancorzo.rickandmorty.storage.db.entities.CharacterEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalPagingApi::class)
class CharacterRepository(
    private val appDatabase: AppDatabase,
    private val remoteMediator: ListRemoteMediator<CharacterListDto, CharacterEntity>
) : CharacterRepositoryAPI {

    override fun getCharacterList(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(PAGE_SIZE),
            remoteMediator = remoteMediator,
            pagingSourceFactory = { appDatabase.characterDao().getAllCharacters() }
        ).flow.map { pagingData ->
            pagingData.map { it.toCharacter() }
        }
    }

}