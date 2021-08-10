package com.tinkooladik.tvshows.screen.show

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.github.michaelbull.result.onFailure
import com.github.michaelbull.result.onSuccess
import com.tinkooladik.tvshows.base.*
import com.tinkooladik.tvshows.common.IllegalState
import com.tinkooladik.tvshows.common.NoData
import com.tinkooladik.tvshows.domain.show.FetchShowUseCase
import com.tinkooladik.tvshows.domain.show.Show
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.annotation.concurrent.Immutable
import javax.inject.Inject

@Immutable
data class ShowDetailsState(
    val show: Async<Show> = Idle
) : UiState

@HiltViewModel
class ShowDetailsViewModel @Inject constructor(
    private val fetchShowUseCase: FetchShowUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<ShowDetailsState, Nothing>() {

    private val showId: Long? = savedStateHandle.get<Long>("showId")

    init {
        fetchShow()
    }

    override fun createInitialState() = ShowDetailsState()

    private fun fetchShow() {
        if (showId == null) {
            setStateScoped { copy(show = Complete.withError(IllegalState)) }
            Timber.e("failed to retrieve show id from args")
            return
        }
        viewModelScope.launch {
            fetchShowUseCase.invoke(showId)
                .onSuccess { show ->
                    setState { copy(show = Complete.withSuccess(show)) }
                }.onFailure { error ->
                    //TODO map error
                    setState { copy(show = Complete.withError(NoData)) }
                }
        }
    }
}