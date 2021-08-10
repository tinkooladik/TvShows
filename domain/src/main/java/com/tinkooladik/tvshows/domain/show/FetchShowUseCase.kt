package com.tinkooladik.tvshows.domain.show

import com.github.michaelbull.result.Result
import com.tinkooladik.tvshows.domain.common.AppDispatchers
import com.tinkooladik.tvshows.domain.common.AppException
import com.tinkooladik.tvshows.domain.common.ErrorInterceptor
import com.tinkooladik.tvshows.domain.common.ResultParamUseCase
import javax.inject.Inject

/**
 * Fetch tv show by it's id
 */
class FetchShowUseCase @Inject constructor(
    private val source: ShowsRepository,
    dispatchers: AppDispatchers,
    errorInterceptor: ErrorInterceptor
) : ResultParamUseCase<Show, Long>(dispatchers.io, errorInterceptor) {

    override suspend fun execute(params: Long): Result<Show, AppException> {
        return source.fetch(params)
    }
}