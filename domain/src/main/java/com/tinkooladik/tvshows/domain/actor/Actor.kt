package com.tinkooladik.tvshows.domain.actor

import java.time.LocalDate

data class Actor(
    val id: Long,
    val name: String,
    val birth: LocalDate,
    val picUrl: String,
)
