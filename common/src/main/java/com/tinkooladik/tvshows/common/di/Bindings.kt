package com.tinkooladik.tvshows.common.di

import com.tinkooladik.tvshows.data.LoggingErrorInterceptor
import com.tinkooladik.tvshows.data.stub.StubActorsRepository
import com.tinkooladik.tvshows.data.stub.StubFavoritesRepository
import com.tinkooladik.tvshows.data.stub.StubShowsRepository
import com.tinkooladik.tvshows.domain.actor.ActorsRepository
import com.tinkooladik.tvshows.domain.common.ErrorInterceptor
import com.tinkooladik.tvshows.domain.favorites.FavoritesRepository
import com.tinkooladik.tvshows.domain.show.ShowsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class Bindings {

    @Binds
    abstract fun provideErrorInterceptor(interceptor: LoggingErrorInterceptor): ErrorInterceptor

    @Binds
    abstract fun provideActorsRepository(source: StubActorsRepository): ActorsRepository

    @Binds
    abstract fun provideShowsRepository(source: StubShowsRepository): ShowsRepository

    @Binds
    abstract fun provideFavoritesRepository(source: StubFavoritesRepository): FavoritesRepository
}