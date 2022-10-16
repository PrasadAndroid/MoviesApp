package com.prasad.moviesgrid.di

import android.content.Context
import com.prasad.moviesgrid.data.repo.MoviesRepo
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class]
)
interface AppComponent {

    fun inject(moviesRepo: MoviesRepo)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun context(context: Context) : Builder

        fun build() : AppComponent
    }
}