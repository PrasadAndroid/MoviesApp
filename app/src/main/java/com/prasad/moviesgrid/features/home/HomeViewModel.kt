package com.prasad.moviesgrid.features.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.prasad.moviesgrid.MoviesApp
import com.prasad.moviesgrid.data.repo.models.MoviesList
import com.prasad.moviesgrid.data.repo.MoviesRepoI
import com.prasad.moviesgrid.extensions.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel(
    app: Application
) : AndroidViewModel(app) {

    @Inject
    lateinit var homeRepoI: MoviesRepoI

    init {
        Log.i(TAG, "View Model creation")
        MoviesApp.dataComponent().inject(this)
    }

    val mErrorLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val mMoviesLiveData: MutableLiveData<MoviesList> by lazy {
        MutableLiveData<MoviesList>()
    }

    val mLoadingLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    private fun <T> publishState(liveData: MutableLiveData<T>, any: T) {
        //always publish on UI thread
        viewModelScope.launch(Dispatchers.Main) {
            liveData.setValue(any)
        }
    }

    fun getMoviesData() {
        publishState(mLoadingLiveData, true)
        viewModelScope.launch {
            val item = homeRepoI.getPopularMoviesList()
            publishState(mLoadingLiveData, false)
            if (item.isSuccessful){
                publishState(mMoviesLiveData, item.body() as MoviesList)
            } else {
                publishState(mErrorLiveData, item.message())
            }
        }
    }

}