package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Ingresar_correo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_correo)

        val btn_scanner: Button = findViewById(R.id.escanear_codigo2)
        btn_scanner.setOnClickListener {
            val intent = Intent(this, Scanner::class.java)
            startActivity(intent)
        }

        val miBoton: Button = findViewById(R.id.ingresar_correo_btn2)
        miBoton.setOnClickListener {
            Toast.makeText(this, "Ya estas en esta pestaña", Toast.LENGTH_SHORT).show()
        }

        val btn_cerrar_sesion: Button = findViewById(R.id.cerrar_sesion_ingresar_correo)
        btn_cerrar_sesion.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}