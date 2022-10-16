package com.prasad.moviesgrid.data.repo.models

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Keep
@Parcelize
data class MoviesList(
    @SerializedName("results")
    @Expose
    var moviesList : List<MovieItem> = emptyList()

): Parcelable {
    @Keep
    @Parcelize
    class MovieItem(
        @SerializedName("title")
        @Expose
        var title: String = "",
        @SerializedName("poster_path")
        @Expose
        var imgUrl: String? = null
    ) : Parcelable
}