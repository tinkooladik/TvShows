package com.tinkooladik.tvshows.domain.actor

import com.github.michaelbull.result.Result
import com.tinkooladik.tvshows.domain.common.AppDispatchers
import com.tinkooladik.tvshows.domain.common.AppException
import com.tinkooladik.tvshows.domain.common.ErrorInterceptor
import com.tinkooladik.tvshows.domain.common.ResultUseCase
import javax.inject.Inject

/**
 * Fetch all actors
 */
class FetchAllActorsUseCase @Inject constructor(
    private val source: ActorsRepository,
    dispatchers: AppDispatchers,
    errorInterceptor: ErrorInterceptor
) : ResultUseCase<List<Actor>>(dispatchers.io, errorInterceptor) {

    override suspend fun execute(): Result<List<Actor>, AppException> {
        return source.fetchAll()
    }
}