package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Crear_Cuenta_De_Acceso_Administrador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta_de_acceso_administrador)

        val regresar: Button = findViewById(R.id.regresar_crear_cuenta_de_acceso)
        regresar.setOnClickListener {
            val intent = Intent(this, Administrador::class.java)
            startActivity(intent)
        }

        val crear_cuenta: Button = findViewById(R.id.crear_cuenta_crear_cuentas_de_acceso)
        crear_cuenta.setOnClickListener {
            val intent = Intent(this, Creacion_de_cuenta_Administrador::class.java)
            startActivity(intent)
        }
    }
}