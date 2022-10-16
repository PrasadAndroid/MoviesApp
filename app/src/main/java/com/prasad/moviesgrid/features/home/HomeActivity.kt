package com.prasad.moviesgrid.features.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.prasad.moviesgrid.R
import com.prasad.moviesgrid.databinding.ActivityGenericContainerBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var mViewBinding: ActivityGenericContainerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_generic_container)
        supportFragmentManager.beginTransaction()
            .replace(mViewBinding.flContainer.id, MoviesGridFragment())
            .commit()
    }
}