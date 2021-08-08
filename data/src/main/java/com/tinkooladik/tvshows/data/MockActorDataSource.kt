package com.tinkooladik.tvshows.data

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.tinkooladik.tvshows.data.Data.ACTORS
import com.tinkooladik.tvshows.domain.actor.Actor
import com.tinkooladik.tvshows.domain.actor.ActorDataSource
import com.tinkooladik.tvshows.domain.common.ActorNotFoundException
import com.tinkooladik.tvshows.domain.common.AppException
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Mock data source is used until server is set up
 */
@Singleton
class MockActorDataSource @Inject constructor() : ActorDataSource {

    private val data: List<Actor> = ACTORS

    override suspend fun fetchAll(): Result<List<Actor>, AppException> {
        delay(200)
        return Ok(data)
    }

    override suspend fun fetch(id: Long): Result<Actor, AppException> {
        val actor = data.firstOrNull { it.id == id }
        delay(200)
        return actor?.let { Ok(it) } ?: Err(ActorNotFoundException())
    }
}