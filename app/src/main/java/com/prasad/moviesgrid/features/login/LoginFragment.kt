package com.djphy.example.moviesgriddisplay.features.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.prasad.moviesgrid.R
import com.prasad.moviesgrid.databinding.FragmentLoginBinding
import com.prasad.moviesgrid.databinding.FragmentMoviesBinding
import com.prasad.moviesgrid.extensions.isValidEmail
import com.prasad.moviesgrid.extensions.isValidPassword
import com.prasad.moviesgrid.features.home.HomeActivity

/**
 * Created by Prasad on 15-10-2022.
 */
class LoginFragment: Fragment(), View.OnClickListener{

    private lateinit var mViewBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mViewBinding = FragmentLoginBinding.inflate(inflater, container, false)

        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewBinding.state = false
        mViewBinding.btnLogin.setOnClickListener(this)
        setTextWatcherLister()
    }

    private fun checkLoginStat() {
        with(mViewBinding) {
            state = etEmailId.text.toString().isValidEmail() && etPassword.text.toString()
                .isValidPassword()
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnLogin ->{
                Intent(requireContext(), HomeActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(this)
                }
            }
        }
    }


    private fun setTextWatcherLister() {
        with(mViewBinding) {
            etEmailId.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable?) {
                    checkLoginStat()
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s.toString().isValidEmail()) {
                        inputLayoutEmailId.isErrorEnabled = false
                    } else {
                        inputLayoutEmailId.error = getString(R.string.error_email)
                    }
                }
            })

            etPassword.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable?) {
                    checkLoginStat()
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s.toString().isValidPassword()) {
                        inputLayoutPassword.isErrorEnabled = false
                    } else {
                        inputLayoutPassword.error = getString(R.string.error_password)
                    }
                }
            })
        }
    }

}