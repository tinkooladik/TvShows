package com.tinkooladik.tvshows.domain.favorites

import com.tinkooladik.tvshows.domain.Completion
import com.tinkooladik.tvshows.domain.common.AppDispatchers
import com.tinkooladik.tvshows.domain.common.AppException
import com.tinkooladik.tvshows.domain.common.CompletionParamUseCase
import com.tinkooladik.tvshows.domain.common.ErrorInterceptor
import javax.inject.Inject

/**
 * Remove the show with particular id from favorites
 * @param - show id to be removed
 */
class RemoveFavoriteUseCase @Inject constructor(
    private val source: FavoritesRepository,
    dispatchers: AppDispatchers,
    errorInterceptor: ErrorInterceptor
) : CompletionParamUseCase<AppException, Long>(dispatchers.io, errorInterceptor) {

    override suspend fun execute(params: Long): Completion<AppException> {
        return source.remove(params)
    }
}