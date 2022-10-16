package com.prasad.moviesgrid.data.remote.network.service

import com.prasad.moviesgrid.data.repo.models.MoviesList
import retrofit2.Response
import retrofit2.http.GET

interface MoviesDataApiService {

    @GET("3/movie/popular")
    suspend fun getPopularMovies(): Response<MoviesList>
}