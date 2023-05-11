package com.example.proyectofinal.model;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle
        import android.widget.ProgreessBar;
import com.github.barkteksc.pdfviewer.PDFView;

public class MainActivity extends AppCompatActivity {
        ProgressBar progressBar;
        PDFView pdfView;

        @Override
        protected void onCreate (Bundle savedInstanceState) {
            supper.onCreate(savedInstanceState);
            setContentView(R.layout.activity_rol_semanal_becario);
            pdfView = findViewById(R.id.pdf_viewer);
            progressBar = findViewById(R.id.progressBar);

            string urlPDF ="https://drive.google.com/drive/my-drive"
            new recibirPDFstream(pdfView.progressBar).execute("urlPdf");
        }
    }
