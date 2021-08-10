package com.tinkooladik.tvshows.screen.home

import androidx.lifecycle.viewModelScope
import com.github.michaelbull.result.onFailure
import com.github.michaelbull.result.onSuccess
import com.tinkooladik.tvshows.base.*
import com.tinkooladik.tvshows.common.NoData
import com.tinkooladik.tvshows.domain.show.FetchAllShowsUseCase
import com.tinkooladik.tvshows.domain.show.Show
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.annotation.concurrent.Immutable
import javax.inject.Inject

@Immutable
data class HomeState(
    val shows: Async<List<Show>> = Idle,
) : UiState

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchAllShowsUseCase: FetchAllShowsUseCase,
) : BaseViewModel<HomeState, Nothing>() {

    init {
        fetchShows()
    }

    override fun createInitialState() = HomeState()

    private fun fetchShows() {
        viewModelScope.launch {
            fetchAllShowsUseCase.invoke()
                .onSuccess { shows ->
                    setState { copy(shows = Complete.withSuccess(shows)) }
                }.onFailure { error ->
                    //TODO map error
                    setState { copy(shows = Complete.withError(NoData)) }
                }
        }
    }
}