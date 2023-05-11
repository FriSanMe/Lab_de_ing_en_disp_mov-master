package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Becario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_becario)

        val codigo_qr: Button = findViewById(R.id.codigo_qr_btn_becario)
        codigo_qr.setOnClickListener {
            val intent = Intent(this, Codigo_QR_Becario::class.java)
            startActivity(intent)
        }

        val rol_semanal_becario: Button = findViewById(R.id.btn_rol_semanal)
        rol_semanal_becario.setOnClickListener {
            val intent = Intent(this, Rol_Semanal_Becario::class.java)
            startActivity(intent)
        }

        val perfil: Button = findViewById(R.id.btn_perfil)
        perfil.setOnClickListener {
            val intent = Intent(this, Perfil_Becario::class.java)
            startActivity(intent)
        }

        val logoutBtn: Button = findViewById(R.id.cerrar_sesion_becario)
        logoutBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // Evitamos que se pueda regresar al login pulsando "atrás"
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            UserStore.logout()
            startActivity(intent)
        }
    }
}