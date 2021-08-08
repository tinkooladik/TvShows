package com.tinkooladik.tvshows.domain.common

import com.github.michaelbull.result.Result
import com.github.michaelbull.result.onFailure
import com.tinkooladik.tvshows.domain.Completion
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

//TODO consider updating these base classes
/**
 * Base UseCase for fetching result
 */
abstract class ResultUseCase<R>(
    dispatcher: CoroutineDispatcher,
    errorInterceptor: ErrorInterceptor
) : ResultParamUseCase<R, Unit>(dispatcher, errorInterceptor) {

    suspend fun invoke(): Result<R, AppException> = invoke(Unit)

    final override suspend fun execute(params: Unit): Result<R, AppException> = execute()

    protected abstract suspend fun execute(): Result<R, AppException>
}

abstract class ResultParamUseCase<R, P>(
    private val dispatcher: CoroutineDispatcher,
    private val errorInterceptor: ErrorInterceptor
) {
    suspend fun invoke(params: P): Result<R, AppException> = withContext(dispatcher) {
        execute(params).onFailure { error -> errorInterceptor.intercept(error) }
    }

    protected abstract suspend fun execute(params: P): Result<R, AppException>
}

/**
 * Base UseCase for observing state
 */
abstract class FlowableParamUseCase<R, P>(
    private val dispatcher: CoroutineDispatcher,
    private val errorInterceptor: ErrorInterceptor
) {

    fun observe(params: P): Flow<R> {
        return execute(params).flowOn(dispatcher)
            .catch { error ->
                errorInterceptor.intercept(error)
                throw error
            }
    }

    protected abstract fun execute(params: P): Flow<R>
}

abstract class FlowableUseCase<R>(
    dispatcher: CoroutineDispatcher,
    errorInterceptor: ErrorInterceptor
) : FlowableParamUseCase<R, Unit>(dispatcher, errorInterceptor) {

    fun observe(): Flow<R> = observe(Unit)

    final override fun execute(params: Unit): Flow<R> = execute()

    protected abstract fun execute(): Flow<R>
}

/**
 * Base UseCase for executing command
 */
abstract class CompletionParamUseCase<E : Throwable, P>(
    private val dispatcher: CoroutineDispatcher,
    private val errorInterceptor: ErrorInterceptor
) {

    suspend fun invoke(params: P): Completion<E> = withContext(dispatcher) {
        execute(params).onFailure { error -> errorInterceptor.intercept(error) }
    }

    protected abstract suspend fun execute(params: P): Completion<E>
}

abstract class CompletionUseCase<E : Throwable>(
    dispatcher: CoroutineDispatcher,
    errorInterceptor: ErrorInterceptor
) : CompletionParamUseCase<E, Unit>(dispatcher, errorInterceptor) {

    suspend fun invoke(): Completion<E> = invoke(Unit)

    final override suspend fun execute(params: Unit): Completion<E> = execute()

    protected abstract suspend fun execute(): Completion<E>
}