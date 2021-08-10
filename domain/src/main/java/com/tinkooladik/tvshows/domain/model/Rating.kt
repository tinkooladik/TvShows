package com.tinkooladik.tvshows.domain.model

@JvmInline
value class Rating(val value: Double) {
    init {
        require(value in 0.0..10.0)
    }
}