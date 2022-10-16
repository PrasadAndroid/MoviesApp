package com.prasad.moviesgrid.features.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prasad.moviesgrid.data.repo.models.MoviesList
import com.prasad.moviesgrid.databinding.ItemMovieBinding

/**
 * Created by Prasad on 15-10-2022.
 */

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ItemViewHolder>() {

    private var mDataList = emptyList<MoviesList.MovieItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayoutBinding = ItemMovieBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(itemLayoutBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(mDataList[position])
    }

    inner class ItemViewHolder(private val itemBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: MoviesList.MovieItem?) {
            item?.let {
                itemBinding.model = item
            }
        }
    }

    override fun getItemCount(): Int = mDataList.size

    fun submitList(dataList: List<MoviesList.MovieItem>){
        mDataList = dataList
        notifyDataSetChanged()
    }
}