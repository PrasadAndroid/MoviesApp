package com.prasad.moviesgrid

import android.app.Application
import com.prasad.moviesgrid.di.AppComponent
import com.prasad.moviesgrid.di.DaggerAppComponent
import com.prasad.moviesgrid.di.DaggerDataComponent
import com.prasad.moviesgrid.di.DataComponent

class MoviesApp : Application() {

    private val appComponent : AppComponent by lazy {
        DaggerAppComponent.builder().context(this).build()
    }

    private val dataComponent : DataComponent by lazy {
        DaggerDataComponent.create()
    }

    init {
        instance = this
    }

    companion object{
        private lateinit var instance: MoviesApp

        fun getApp() : MoviesApp {
            return instance
        }

        fun appComponent(): AppComponent {
            return instance.appComponent
        }

        fun dataComponent(): DataComponent {
            return instance.dataComponent
        }
    }
}