package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Rol_Semanal_Administrador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rol_semanal_administrador)

        val regresar: Button = findViewById(R.id.regresar_rol_semanal_administrador)
        regresar.setOnClickListener {
            val intent = Intent(this, Administrador::class.java)
            startActivity(intent)
        }
    }
}