package com.tinkooladik.tvshows.common.di

import com.tinkooladik.tvshows.data.LoggingErrorInterceptor
import com.tinkooladik.tvshows.data.MockActorDataSource
import com.tinkooladik.tvshows.domain.actor.ActorDataSource
import com.tinkooladik.tvshows.domain.common.ErrorInterceptor
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
    abstract fun provideActorDataSource(source: MockActorDataSource): ActorDataSource
}