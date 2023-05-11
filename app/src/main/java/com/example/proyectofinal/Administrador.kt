package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Administrador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_administrador)

        val estudiantes: Button = findViewById(R.id.btn_estudiantes)
        estudiantes.setOnClickListener {
            val intent = Intent(this, Estudiantes_Administrador::class.java)
            startActivity(intent)
        }

        val crear_cuenta_de_acceso: Button = findViewById(R.id.btn_crear_cuenta_de_acceso)
        crear_cuenta_de_acceso.setOnClickListener {
            val intent = Intent(this, Crear_Cuenta_De_Acceso_Administrador::class.java)
            startActivity(intent)
        }

        val control_de_acceso: Button = findViewById(R.id.btn_control_de_acceso)
        control_de_acceso.setOnClickListener {
            val intent = Intent(this, Control_De_Acceso_Administrador::class.java)
            startActivity(intent)
        }

        val rol_semanal: Button = findViewById(R.id.btn_rol_semanal_admin)
        rol_semanal.setOnClickListener {
            val intent = Intent(this, Rol_Semanal_Administrador::class.java)
            startActivity(intent)
        }

        val logoutBtn: Button = findViewById(R.id.cerrar_sesion)
        logoutBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // Evitamos que se pueda regresar al login pulsando "atrás"
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            UserStore.logout()
            startActivity(intent)
        }

        val scanner: Button = findViewById(R.id.btn_scanner)
        scanner.setOnClickListener {
            val intent = Intent(this, Scanner::class.java)
            startActivity(intent)
        }
    }
}