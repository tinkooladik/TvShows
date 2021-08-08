package com.tinkooladik.tvshows.domain.common

sealed class AppException(
    message: String? = null, cause: Throwable? = null
) : Throwable(message, cause)

class ActorNotFoundException : AppException()