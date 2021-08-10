package com.tinkooladik.tvshows.data.stub

import com.tinkooladik.tvshows.domain.actor.Actor
import com.tinkooladik.tvshows.domain.model.Country
import com.tinkooladik.tvshows.domain.model.Genre
import com.tinkooladik.tvshows.domain.model.Rating
import com.tinkooladik.tvshows.domain.show.Show
import java.time.LocalDate

//just to have some data to show.
//TODO move this to json or protobuf file please. (and to backend eventually)
object StubData {

    private val ACTORS_MONEY_HEIST = listOf(
        Actor(
            id = 0,
            name = "Úrsula Corberó",
            birth = LocalDate.of(1989, 1, 9),
            imageUrl = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTV_IdsV5Oel7GhWGs-MfJNhsh1RsKOtwkxrK4csIjuFjAhTLGK"
        ),
        Actor(
            id = 1,
            name = "Álvaro Morte",
            birth = LocalDate.of(1976, 2, 23),
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSW32Qfsda8w5O28bc9-GX3u_w-9hqJCPVCOvgNV_W9XEv9PziO"
        ),
        Actor(
            id = 2,
            name = "Miguel Herrán",
            birth = LocalDate.of(1996, 4, 25),
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPZ-ykwJvwikkP3V1PJ4zPNed-Dwe5IKtzNDGSCMag-jfqc_9M"
        ),
        Actor(
            id = 3,
            name = "Jaime Lorente",
            birth = LocalDate.of(1991, 12, 12),
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThZWJx32e7vvzK-_Ok8rl2M6ZtEKhiHz9-uAAJcMVwAKPabKAJ"
        ),
    )

    private val ACTORS_ELITE = listOf(
        Actor(
            id = 4,
            name = "Arón Piper",
            birth = LocalDate.of(1997, 3, 29),
            imageUrl = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRbNry4peoUQzDZQZdjYani-YzGC-iBd65G1nqFc8JmUnLCebp6"
        ),
        Actor(
            id = 5,
            name = "Itzan Escamilla",
            birth = LocalDate.of(1997, 10, 31),
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRr5JOBhJM2PnCIWnXFIbB5TxX5-dNgX7RPkk64huusYyvbcexp"
        ),
    )

    val ACTORS = ACTORS_MONEY_HEIST + ACTORS_ELITE

    val SHOWS = listOf(
        Show(
            id = 0,
            title = "Money Heist",
            releaseDate = LocalDate.of(2017, 4, 12),
            actors = ACTORS_MONEY_HEIST,
            country = Country.Spain,
            genres = listOf(Genre.Thriller, Genre.Crime, Genre.Drama),
            rating = Rating(8.3),
            seasons = 2,
            episodes = 31,
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAD_Ll60VwQMFMYh28vheB_dI3Xud-wlVYBw&usqp=CAU"
        ),
        Show(
            id = 1,
            title = "Elite",
            releaseDate = LocalDate.of(2018, 3, 4),
            actors = ACTORS_ELITE,
            country = Country.Spain,
            genres = listOf(Genre.TeenDrama, Genre.Thriller),
            rating = Rating(7.5),
            seasons = 4,
            episodes = 32,
            imageUrl = "https://citaty.info/files/posters/214160.jpg"
        )
    )
}