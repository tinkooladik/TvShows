package com.tinkooladik.tvshows.data

import com.tinkooladik.tvshows.domain.common.ErrorInterceptor
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoggingErrorInterceptor @Inject constructor() : ErrorInterceptor {

    override fun intercept(error: Throwable) {
        Timber.e(error)
    }
}