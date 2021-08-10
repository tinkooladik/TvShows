package com.tinkooladik.tvshows.domain.show

import com.github.michaelbull.result.Result
import com.tinkooladik.tvshows.domain.common.AppDispatchers
import com.tinkooladik.tvshows.domain.common.AppException
import com.tinkooladik.tvshows.domain.common.ErrorInterceptor
import com.tinkooladik.tvshows.domain.common.ResultUseCase
import javax.inject.Inject

class FetchAllShowsUseCase @Inject constructor(
    private val source: ShowsRepository,
    dispatchers: AppDispatchers,
    errorInterceptor: ErrorInterceptor
) : ResultUseCase<List<Show>>(dispatchers.io, errorInterceptor) {

    override suspend fun execute(): Result<List<Show>, AppException> {
        return source.fetchAll()
    }
}