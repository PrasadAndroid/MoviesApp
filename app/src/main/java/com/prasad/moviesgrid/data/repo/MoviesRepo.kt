package com.prasad.moviesgrid.data.repo

import com.prasad.moviesgrid.MoviesApp
import com.prasad.moviesgrid.data.remote.network.service.MoviesDataApiService
import com.prasad.moviesgrid.data.repo.models.MoviesList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class MoviesRepo: MoviesRepoI {

    @Inject
    lateinit var apiService: MoviesDataApiService

    init {
        MoviesApp.appComponent().inject(this)
    }

    override suspend fun getPopularMoviesList(): Response<MoviesList> {
        return withContext(Dispatchers.IO){
            apiService.getPopularMovies()
        }
    }

}