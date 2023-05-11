package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Perfil_Becario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_becario)

        val btn_regresar: Button = findViewById(R.id.regresar_perfil)
        btn_regresar.setOnClickListener {
            val intent = Intent(this, Becario::class.java)
            startActivity(intent)
        }
    }
}