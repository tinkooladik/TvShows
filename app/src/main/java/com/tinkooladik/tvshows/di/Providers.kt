package com.tinkooladik.tvshows.di

import com.tinkooladik.tvshows.domain.common.AppDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import timber.log.Timber

@InstallIn(SingletonComponent::class)
@Module
object Providers {

    @Provides
    fun provideAppDispatchers() = AppDispatchers(
        Dispatchers.IO, Dispatchers.Default, Dispatchers.Main
    )

    @Provides
    fun provideTree(): Timber.Tree {
        return Timber.DebugTree()
    }
}