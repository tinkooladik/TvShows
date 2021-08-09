package com.tinkooladik.tvshows.base

sealed class Async<out V>

object Idle : Async<Nothing>(), Incomplete
object Loading : Async<Nothing>(), Incomplete

data class Success<out V>(val value: V) : Complete<V>()
data class Fail(val error: UiError) : Complete<Nothing>()

sealed class Complete<out V> : Async<V>() {
    companion object {
        fun withError(error: UiError): Fail {
            return Fail(error)
        }

        fun <V> withSuccess(value: V): Success<V> {
            return Success(value)
        }
    }
}

val <V> Async<V>.value: V?
    get() = if (this is Success) value else null

interface Incomplete

inline fun <V, E> Async<V>.onSuccess(action: (V) -> Unit): Async<V> {
    if (this is Success) {
        action(value)
    }
    return this
}

inline fun <V, E> Async<V>.onFailure(action: (UiError) -> Unit): Async<V> {
    if (this is Fail) {
        action(error)
    }
    return this
}

inline fun <V, E> Async<V>.onLoading(action: () -> Unit): Async<V> {
    if (this is Loading) {
        action()
    }
    return this
}

inline fun <V, E> Async<V>.onComplete(action: () -> Unit): Async<V> {
    if (this is Complete) {
        action()
    }
    return this
}

inline fun <V, E> Async<V>.onIncomplete(action: () -> Unit): Async<V> {
    if (this is Incomplete) {
        action()
    }
    return this
}