package com.example.proyectofinal.data

import com.example.proyectofinal.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

object UsersRepository {
    private val db = Firebase.firestore
    suspend fun find(userId: String): User? {
        val doc = db.collection("users").document(userId).get().await()
        if (!doc.exists()) return null
        val data = doc.data!!
        return User(doc.id, data["role"] as String)
    }
}