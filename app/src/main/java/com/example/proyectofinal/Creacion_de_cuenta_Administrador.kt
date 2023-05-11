package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Creacion_de_cuenta_Administrador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creacion_de_cuenta_administrador)

        val regresar: Button = findViewById(R.id.regresar_creacion_de_cuenta)
        regresar.setOnClickListener {
            val intent = Intent(this, Crear_Cuenta_De_Acceso_Administrador::class.java)
            startActivity(intent)
        }

        val aceptar: Button = findViewById(R.id.btn_aceptar_creacion_de_cuenta)
        aceptar.setOnClickListener {
            val intent = Intent(this, Crear_Cuenta_De_Acceso_Administrador::class.java)
            startActivity(intent)
        }
    }
}