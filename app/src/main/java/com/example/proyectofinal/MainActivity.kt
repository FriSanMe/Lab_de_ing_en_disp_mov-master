package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.lifecycleScope
import com.example.proyectofinal.data.UsersRepository
import com.example.proyectofinal.databinding.ActivityMainBinding
import com.example.proyectofinal.model.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class MainActivity : AppCompatActivity() {
    private val userTypes = arrayOf("Administrador", "Becario | Servicio Social")
    private val auth by lazy { FirebaseAuth.getInstance() }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.iniciarSesion.setOnClickListener {
            onLoginClick()
        }
        binding.botonDuda.setOnClickListener {
            onFAQClick()
        }
    }

    override fun onResume() {
        super.onResume()
        if (auth.currentUser != null) {
            lifecycleScope.launch {
                try {
                    val user = UsersRepository.find(auth.currentUser!!.uid)!!
                    onUserLoggedIn(user)
                } catch (e: Exception) {
                    // Por algún motivo no pudimos obtener el usuario de la firestore, hacemos logout
                    // ya que no queremos que el usuario ingrese a la app sin tener su documento en
                    // la firestore
                    auth.signOut()
                    e.printStackTrace()
                }
            }
        }
    }

    private fun onLoginClick() = lifecycleScope.launch {
        try {
            val authResult =
                auth.signInWithEmailAndPassword(
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString()
                ).await()
            onUserLoggedIn(UsersRepository.find(authResult.user!!.uid)!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this@MainActivity, "Credenciales inválidas", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onUserLoggedIn(user: User) {
        UserStore.userFromAuth = user
        if (user.role == userTypes[0]) {
            val intent = Intent(this@MainActivity, Administrador::class.java)
            // Evitamos que se pueda regresar al login pulsando "atrás"
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        } else if (user.role == userTypes[1]) {
            val intent = Intent(this@MainActivity, Becario::class.java)
            // Evitamos que se pueda regresar al login pulsando "atrás"
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    private fun onFAQClick() {
        val intent = Intent(this, preguntas_frecuentes::class.java)
        startActivity(intent)
    }

}