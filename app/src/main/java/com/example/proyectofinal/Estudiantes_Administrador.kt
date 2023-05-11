package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Estudiantes_Administrador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudiantes_administrador)

        val regresar: Button = findViewById(R.id.regresar_estudiantes)
        regresar.setOnClickListener {
            val intent = Intent(this, Administrador::class.java)
            startActivity(intent)
        }

        val cerrar_sesion: Button = findViewById(R.id.cerrar_sesion_estudiantes)
        cerrar_sesion.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}