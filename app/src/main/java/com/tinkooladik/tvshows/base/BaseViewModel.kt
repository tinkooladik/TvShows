package com.tinkooladik.tvshows.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

abstract class BaseViewModel<S : UiState, E : Event> : ViewModel(), UiStateProvider {

    private val initialState: S by lazy { createInitialState() }
    abstract fun createInitialState(): S

    val currentState: S
        get() = uiState.value

    private val _uiState: MutableStateFlow<S> = MutableStateFlow(initialState)
    override val uiState = _uiState.asStateFlow()

    private val _events: Channel<E> = Channel(Channel.UNLIMITED)
    override val events = _events.receiveAsFlow()

    private val stateMutex = Mutex()

    protected suspend fun setState(reducer: S.() -> S) {
        stateMutex.withLock {
            _uiState.value = _uiState.value.reducer()
        }
    }

    protected fun setStateScoped(reducer: S.() -> S) {
        viewModelScope.launch {
            setState(reducer)
        }
    }

    protected fun sendEvent(event: E) {
        _events.offer(event)
    }
}

interface UiState
interface Event

interface UiStateProvider {
    val uiState: StateFlow<UiState>
    val events: Flow<Event>
}