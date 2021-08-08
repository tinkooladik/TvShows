package com.tinkooladik.tvshows.data

import com.tinkooladik.tvshows.domain.actor.Actor
import java.time.LocalDate

object Data {

    val ACTORS = listOf(
        Actor(
            id = 0,
            name = "Nina Dobrev",
            birth = LocalDate.of(1989, 1, 9)
        )
    )
}