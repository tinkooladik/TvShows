package com.tinkooladik.tvshows.data.stub

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.tinkooladik.tvshows.data.stub.StubData.SHOWS
import com.tinkooladik.tvshows.domain.common.ActorNotFoundException
import com.tinkooladik.tvshows.domain.common.AppException
import com.tinkooladik.tvshows.domain.model.Genre
import com.tinkooladik.tvshows.domain.show.Show
import com.tinkooladik.tvshows.domain.show.ShowsRepository
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Stub data source is used until server is set up
 */
@Singleton
class StubShowsRepository @Inject constructor() : ShowsRepository {

    private val data: List<Show> = SHOWS

    override suspend fun fetchAll(): Result<List<Show>, AppException> {
        delay(200)
        return Ok(data)
    }

    override suspend fun fetch(id: Long): Result<Show, AppException> {
        val show = data.firstOrNull { it.id == id }
        delay(400)
        return show?.let { Ok(it) } ?: Err(ActorNotFoundException())
    }

    override suspend fun fetchByGenre(genre: Genre): Result<List<Show>, AppException> {
        delay(200)
        return Ok(data.filter { show -> genre in show.genres })
    }
}