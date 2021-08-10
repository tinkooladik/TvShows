package com.tinkooladik.tvshows.domain.favorites

import com.tinkooladik.tvshows.domain.Completion
import com.tinkooladik.tvshows.domain.common.AppDispatchers
import com.tinkooladik.tvshows.domain.common.AppException
import com.tinkooladik.tvshows.domain.common.CompletionParamUseCase
import com.tinkooladik.tvshows.domain.common.ErrorInterceptor
import com.tinkooladik.tvshows.domain.show.Show
import javax.inject.Inject

/**
 * Add a show to favorites. Favorites stored only during runtime for now.
 * @param - show to be added
 */
class AddFavoriteUseCase @Inject constructor(
    private val source: FavoritesRepository,
    dispatchers: AppDispatchers,
    errorInterceptor: ErrorInterceptor
) : CompletionParamUseCase<AppException, Show>(dispatchers.io, errorInterceptor) {

    override suspend fun execute(params: Show): Completion<AppException> {
        return source.add(params)
    }
}