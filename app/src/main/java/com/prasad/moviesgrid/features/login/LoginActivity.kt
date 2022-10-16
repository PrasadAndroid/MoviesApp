package com.prasad.moviesgrid.features.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.djphy.example.moviesgriddisplay.features.login.LoginFragment
import com.prasad.moviesgrid.R
import com.prasad.moviesgrid.databinding.ActivityGenericContainerBinding

/**
 * Created by Prasad on 15-10-2022.
 */

class LoginActivity : AppCompatActivity(){

    private lateinit var mViewBinding: ActivityGenericContainerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_generic_container)
        supportFragmentManager.beginTransaction()
            .replace(mViewBinding.flContainer.id, LoginFragment())
            .commit()
    }

}