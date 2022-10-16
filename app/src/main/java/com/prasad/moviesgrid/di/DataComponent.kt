package com.prasad.moviesgrid.di

import com.prasad.moviesgrid.features.home.HomeViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class
    ]
)
interface DataComponent {
    fun inject(homeViewModel: HomeViewModel)
}