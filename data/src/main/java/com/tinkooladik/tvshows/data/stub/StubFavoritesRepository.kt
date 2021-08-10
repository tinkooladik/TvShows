package com.tinkooladik.tvshows.data.stub

import com.github.michaelbull.result.Ok
import com.tinkooladik.tvshows.domain.Completion
import com.tinkooladik.tvshows.domain.common.AppException
import com.tinkooladik.tvshows.domain.favorites.FavoritesRepository
import com.tinkooladik.tvshows.domain.show.Show
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Stub data source is used until server is set up
 */
@Singleton
class StubFavoritesRepository @Inject constructor() : FavoritesRepository {

    private val data: MutableStateFlow<List<Show>> = MutableStateFlow(emptyList())

    override fun observe(): Flow<List<Show>> = data

    override suspend fun add(show: Show): Completion<AppException> {
        delay(200)
        data.value += show
        return Ok(Unit)
    }

    override suspend fun remove(showId: Long): Completion<AppException> {
        delay(200)
        data.value = data.value.filterNot { it.id == showId }
        return Ok(Unit)
    }
}