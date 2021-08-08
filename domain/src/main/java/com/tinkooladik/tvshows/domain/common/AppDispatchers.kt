package com.tinkooladik.tvshows.domain.common

import kotlinx.coroutines.CoroutineDispatcher

class AppDispatchers(
    val io: CoroutineDispatcher,
    val computation: CoroutineDispatcher,
    val main: CoroutineDispatcher
)