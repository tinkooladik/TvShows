package com.tinkooladik.tvshows.domain.model

@JvmInline
value class Rating(private val r: Double) {
    init {
        require(r in 0.0..10.0)
    }
}