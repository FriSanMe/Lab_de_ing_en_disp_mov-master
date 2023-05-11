package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class Notificar_Administrador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificar_administrador)

        val regresar: Button = findViewById(R.id.regresar_notificar)
        regresar.setOnClickListener {
            val intent = Intent(this, Administrador::class.java)
            startActivity(intent)
        }

        //val btn: Button = findViewById(R.id.enviar_notificar_administrador)
        lateinit var spinner1: Spinner
        spinner1 = findViewById(R.id.spinner2) as Spinner

        val opciones = arrayOf("Administrador", "Becario | Servicio Social")
        val adapter = ArrayAdapter(this, R.layout.spinner_item_opciones, opciones)
        spinner1.adapter = adapter

        /*btn.setOnClickListener {
            val seleccion = spinner1.selectedItem.toString()
            if (seleccion == "Administrador") {
                val intent = Intent(this, Administrador::class.java)
                startActivity(intent)
            } else if (seleccion == "Becario | Servicio Social") {
                val intent1 = Intent(this, Becario::class.java)
                startActivity(intent1)
            } else if (seleccion == "Scanner") {
                val intent2 = Intent(this, Scanner::class.java)
                startActivity(intent2)
            }
        }*/
    }
}