package com.tinkooladik.tvshows.ui.home

import androidx.lifecycle.viewModelScope
import com.github.michaelbull.result.onFailure
import com.github.michaelbull.result.onSuccess
import com.tinkooladik.tvshows.base.*
import com.tinkooladik.tvshows.domain.actor.Actor
import com.tinkooladik.tvshows.domain.actor.FetchAllActorsUseCase
import com.tinkooladik.tvshows.domain.show.Show
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.annotation.concurrent.Immutable
import javax.inject.Inject

@Immutable
data class HomeState(
    val shows: Async<List<Show>> = Idle,
    val actors: Async<List<Actor>> = Idle,
) : UiState

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchAllActorsUseCase: FetchAllActorsUseCase
) : BaseViewModel<HomeState, Nothing>() {

    init {
        fetchActors()
    }

    override fun createInitialState() = HomeState()

    private fun fetchActors() {
        viewModelScope.launch {
            fetchAllActorsUseCase.invoke()
                .onSuccess { actors ->
                    setState { copy(actors = Complete.withSuccess(actors)) }
                }.onFailure { error ->
                    //TODO map error
                    setState { copy(actors = Complete.withError(NoData)) }
                }
        }
    }
}