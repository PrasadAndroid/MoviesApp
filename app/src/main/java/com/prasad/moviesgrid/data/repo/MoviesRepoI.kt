package com.prasad.moviesgrid.data.repo

import com.prasad.moviesgrid.data.repo.models.MoviesList
import retrofit2.Response

interface MoviesRepoI {

    suspend fun getPopularMoviesList() : Response<MoviesList>

}