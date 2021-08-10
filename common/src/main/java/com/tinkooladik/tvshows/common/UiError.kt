package com.tinkooladik.tvshows.common

sealed class UiError

object NoConnection : UiError()
object NoData : UiError()
object IllegalState : UiError()