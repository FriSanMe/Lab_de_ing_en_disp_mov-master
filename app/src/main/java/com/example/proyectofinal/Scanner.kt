package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.proyectofinal.databinding.ActivityScannerBinding
import com.google.zxing.integration.android.IntentIntegrator

class Scanner : AppCompatActivity() {

    private lateinit var binding: ActivityScannerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScanner.setOnClickListener{initScanner()}

        val miBoton: Button = findViewById(R.id.escanear_codigo)
        miBoton.setOnClickListener {
            Toast.makeText(this, "Ya estás en esta pestaña.", Toast.LENGTH_SHORT).show()
        }

        val btn_ingresar_correo: Button = findViewById(R.id.ingresar_correo_btn)
        btn_ingresar_correo.setOnClickListener {
            val intent = Intent(this, Ingresar_correo::class.java)
            startActivity(intent)
        }

        val btn_cerrar_sesion: Button = findViewById(R.id.cerrar_sesion_scanner)
        btn_cerrar_sesion.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initScanner() {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)                               //solo los codigos Qr
        integrator.setPrompt("Escanea el Codigo Qr")
        //integrator.setTorchEnabled(true)                                                          //Opcion para tener la linterna encendida
        integrator.setBeepEnabled(true)
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if(result != null){
            if(result.contents == null){
                Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "El valor escaneado es: ${result.contents}", Toast.LENGTH_SHORT).show()
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}