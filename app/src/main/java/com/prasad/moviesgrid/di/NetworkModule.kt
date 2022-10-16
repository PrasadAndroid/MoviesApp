package com.prasad.moviesgrid.di

import android.content.Context
import androidx.annotation.NonNull
import com.google.gson.GsonBuilder
import com.prasad.moviesgrid.data.remote.network.interceptor.ApiKeyRequestInterceptor
import com.prasad.moviesgrid.data.remote.network.service.MoviesDataApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object{
        const val BASE_URL = "https://api.themoviedb.org/"
    }

    @Provides
    @Singleton
    fun provideHttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .callTimeout(300, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addNetworkInterceptor(ApiKeyRequestInterceptor())
            .retryOnConnectionFailure(true)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@NonNull okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation().create()))
            .build()
    }

    @Provides
    @Singleton
    fun provideMoviesApiService(@NonNull retrofit: Retrofit): MoviesDataApiService {
        return retrofit.create(MoviesDataApiService::class.java)
    }
}