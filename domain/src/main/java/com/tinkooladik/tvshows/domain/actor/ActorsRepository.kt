package com.tinkooladik.tvshows.domain.actor

import com.github.michaelbull.result.Result
import com.tinkooladik.tvshows.domain.common.AppException

interface ActorsRepository {

    suspend fun fetchAll(): Result<List<Actor>, AppException>

    suspend fun fetch(id: Long): Result<Actor, AppException>
}