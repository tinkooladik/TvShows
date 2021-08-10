package com.tinkooladik.tvshows.domain.favorites

import com.tinkooladik.tvshows.domain.Completion
import com.tinkooladik.tvshows.domain.common.AppException
import com.tinkooladik.tvshows.domain.show.Show
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {

    fun observe(): Flow<List<Show>>

    suspend fun add(show: Show): Completion<AppException>

    suspend fun remove(showId: Long): Completion<AppException>
}