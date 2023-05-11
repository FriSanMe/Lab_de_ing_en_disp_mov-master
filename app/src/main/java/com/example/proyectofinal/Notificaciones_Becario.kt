package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Notificaciones_Becario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificaciones_becario)

        val cerrar_sesion: Button = findViewById(R.id.cerrar_sesion_notificaciones)
        cerrar_sesion.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val regresar: Button = findViewById(R.id.regresar_notificaciones)
        regresar.setOnClickListener {
            val intent = Intent(this, Becario::class.java)
            startActivity(intent)
        }
    }
}