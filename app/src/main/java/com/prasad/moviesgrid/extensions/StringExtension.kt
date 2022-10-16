package com.prasad.moviesgrid.extensions

import android.util.Patterns

/**
 * Created by Prasad on 14-10-2022.
 */
fun String.isValidEmail(): Boolean {
    return this.isValid() && Patterns.EMAIL_ADDRESS.matcher(this)
        .matches()
}

fun String.isValidPassword(): Boolean {
    return this.isValid() && this.length >= 6 && this.length <= 12
}

fun String.isValid(): Boolean {
    return this.isNotEmpty() && this.isNotBlank()
}