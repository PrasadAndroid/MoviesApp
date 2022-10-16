package com.prasad.moviesgrid.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.prasad.moviesgrid.data.repo.models.MoviesList
import com.prasad.moviesgrid.databinding.FragmentMoviesBinding
import com.prasad.moviesgrid.extensions.createFactory
import com.prasad.moviesgrid.extensions.toast

/**
 * Created by Prasad on 15-10-2022.
 */
class MoviesGridFragment: Fragment(){

    private lateinit var mViewBinding: FragmentMoviesBinding
    private lateinit var mViewModel: HomeViewModel
    private lateinit var mAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mViewBinding = FragmentMoviesBinding.inflate(inflater, container, false)

        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVm()
        initAdapter()
        initDataProvider()
    }

    private fun initDataProvider() {
        mViewModel.getMoviesData()
    }

    private fun initAdapter() {
        with(mViewBinding) {
            recyclerView.apply {
                layoutManager = GridLayoutManager(
                    requireContext(), 2,
                    GridLayoutManager.VERTICAL, false
                )
                mAdapter = MoviesAdapter()
                adapter = mAdapter
            }
        }
    }

    private fun initVm() {
        val factory = HomeViewModel(
            requireActivity().application
        ).createFactory()
        mViewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)
        setObservers()
    }

    private fun setObservers() {
        with(mViewModel) {
            mMoviesLiveData.observe(viewLifecycleOwner) {
                updateList(it.moviesList)
            }
            mErrorLiveData.observe(viewLifecycleOwner){
                mViewBinding.message = it
                displayError(it)
            }
            mLoadingLiveData.observe(viewLifecycleOwner){
                mViewBinding.state = it
            }
        }
    }

    private fun updateList(moviesList: List<MoviesList.MovieItem>){
        mAdapter.submitList(moviesList)
    }

    private fun displayError(string: String){
        toast(string)
    }

}