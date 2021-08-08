package com.tinkooladik.tvshows.domain.model

@JvmInline
value class Rating(private val r: Float) {
    init {
        require(r in 0.0..5.0)
    }
}