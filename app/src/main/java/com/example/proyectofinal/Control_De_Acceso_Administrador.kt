package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Control_De_Acceso_Administrador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control_de_acceso_administrador)

        val regresar: Button = findViewById(R.id.regresar_control_de_acceso)
        regresar.setOnClickListener {
            val intent = Intent(this, Administrador::class.java)
            startActivity(intent)
        }
    }
}