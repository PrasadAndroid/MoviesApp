package com.prasad.moviesgrid.di

import com.prasad.moviesgrid.data.repo.MoviesRepo
import com.prasad.moviesgrid.data.repo.MoviesRepoI
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataModule {

    @Singleton
    @Provides
    fun provideHomeRepositoryI(): MoviesRepoI {
        return MoviesRepo()
    }
}