package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button




class Rol_Semanal_Becario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rol_semanal_becario)

        val btn_regresar: Button = findViewById(R.id.regresar_rol_semanal)
        btn_regresar.setOnClickListener {
            val intent = Intent(this, Becario::class.java)
            startActivity(intent)
        }

        val cerrar_sesion: Button = findViewById(R.id.cerrar_sesion_rol_semanal)
        cerrar_sesion.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}