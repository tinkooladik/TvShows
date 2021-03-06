package com.tinkooladik.tvshows.domain.show

import com.tinkooladik.tvshows.domain.actor.Actor
import com.tinkooladik.tvshows.domain.model.Country
import com.tinkooladik.tvshows.domain.model.Genre
import com.tinkooladik.tvshows.domain.model.Rating
import java.time.LocalDate

data class Show(
    val id: Long,
    val title: String,
    val releaseDate: LocalDate,
    val actors: List<Actor>,
    val country: Country,
    val genres: List<Genre>,
    val rating: Rating,
    val seasons: Int,
    val episodes: Int,
    val imageUrl: String,
)
