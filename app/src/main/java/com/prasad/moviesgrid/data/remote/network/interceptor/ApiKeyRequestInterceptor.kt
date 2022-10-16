package com.prasad.moviesgrid.data.remote.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response


class ApiKeyRequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("api_key", "f09583134d0bc3db035c5656a6b70f32")
            .build()
        request = request.newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }


}