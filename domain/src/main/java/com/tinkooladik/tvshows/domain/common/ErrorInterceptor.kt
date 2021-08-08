package com.tinkooladik.tvshows.domain.common

interface ErrorInterceptor {
    fun intercept(error: Throwable) {}
}