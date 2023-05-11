package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder

class Codigo_QR_Becario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_codigo_qr_becario)
        val imgQr = findViewById<ImageView>(R.id.qrCode)

        val txtDatos = "1675010"

        if (txtDatos.matches(Regex("\\d+"))) {
            try {
                val barcodeEncoder = BarcodeEncoder()
                val bitmap = barcodeEncoder.encodeBitmap(
                    txtDatos,
                    BarcodeFormat.QR_CODE,
                    750,
                    750
                )
                imgQr.setImageBitmap(bitmap)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            Toast.makeText(
                applicationContext,
                "Ingrese solo números.",
                Toast.LENGTH_SHORT
            ).show()
        }

        val btn_regresar: Button = findViewById(R.id.regresar_becario)
        btn_regresar.setOnClickListener {
            val intent = Intent(this, Becario::class.java)
            startActivity(intent)
        }

        val btn_cerrar_sesion: Button = findViewById(R.id.cerrar_sesion_Qr)
        btn_cerrar_sesion.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}