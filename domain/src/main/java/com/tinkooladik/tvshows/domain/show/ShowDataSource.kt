package com.tinkooladik.tvshows.domain.show

import com.github.michaelbull.result.Result
import kotlinx.coroutines.flow.Flow

interface ShowDataSource {

    fun observeShows(): Flow<List<Show>>

    suspend fun fetch(id: Long): Result<Show, Exception>
}