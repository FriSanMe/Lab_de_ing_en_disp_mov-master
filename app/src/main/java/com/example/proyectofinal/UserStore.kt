package com.example.proyectofinal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.proyectofinal.model.User
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

object UserStore {
    val auth = Firebase.auth
    var userFromAuth: User? = null
    fun logout() {
        userFromAuth = null
        auth.signOut()
    }
}