package com.tinkooladik.tvshows.extentions

import androidx.core.widget.ContentLoadingProgressBar

var ContentLoadingProgressBar.isLoading: Boolean
    get() = isShown
    set(value) {
        if (value) show() else hide()
    }