package com.tinkooladik.tvshows.base

sealed class UiError

object NoConnection : UiError()
object NoData : UiError()