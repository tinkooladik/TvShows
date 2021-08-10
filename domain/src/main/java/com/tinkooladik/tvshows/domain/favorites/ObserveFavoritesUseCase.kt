package com.tinkooladik.tvshows.domain.favorites

import com.tinkooladik.tvshows.domain.common.AppDispatchers
import com.tinkooladik.tvshows.domain.common.ErrorInterceptor
import com.tinkooladik.tvshows.domain.common.FlowableUseCase
import com.tinkooladik.tvshows.domain.show.Show
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Observe user's favorites. Favorites stored only during runtime for now.
 */
class ObserveFavoritesUseCase @Inject constructor(
    private val source: FavoritesRepository,
    dispatchers: AppDispatchers,
    errorInterceptor: ErrorInterceptor
) : FlowableUseCase<List<Show>>(dispatchers.io, errorInterceptor) {

    override fun execute(): Flow<List<Show>> {
        return source.observe()
    }
}