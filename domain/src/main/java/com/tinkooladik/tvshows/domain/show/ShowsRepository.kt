package com.tinkooladik.tvshows.domain.show

import com.github.michaelbull.result.Result
import com.tinkooladik.tvshows.domain.common.AppException
import com.tinkooladik.tvshows.domain.model.Genre

interface ShowsRepository {

    suspend fun fetchAll(): Result<List<Show>, AppException>

    suspend fun fetch(id: Long): Result<Show, AppException>

    suspend fun fetchByGenre(genre: Genre): Result<List<Show>, AppException>
}