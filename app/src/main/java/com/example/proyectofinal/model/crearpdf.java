package com.example.proyectofinal.model;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.example.proyectofinal.R;

public class crearpdf extends AppCompatActivity {

   Button btncrearpdf;

    String tituloText = "Rol semanal";
    String descripcion ="Estimado alumno en este apartado podras encontrar a quienes les toca descanso.\n"+
            "Así mismo podras visualizar el piso que toca cubrir o evento\n"+ "Te recordamos que este rol cambia por semana";


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rol_semanal_administrador);

        if(checkPermission()){
            Toast.makeText(context:this,text "Permiso Aceptado",Toast.LENGTH_LONG).show();
        } else {
            requestPermissions();
        }

        btncrearpdf = findViewById(R.id.btncrearpdf);
        btncrearpdf.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
               generarpdf();
            }
    }
    }
       public void generarpdf();{
        PdfDocument pdfDocument = new PdfDocument();
        Paint paint = new Paint();
        TextPaint_titulo = new TextPaint();
        TextPaint descripcion = new TextPaint();

        Bitmap bitmap, bitmapEscala;

        PdfDocument.PageInfo paginaInfo = new PdfDocument.PageInfo.Builder(pageWidth: 816, pageHeight: 1854, pageNumber: 1).create();
        PdfDocument.Page pagina1 = pdfDocument.startPage(paginaInfo);

        Canvas canvas = pagina1.getCanvas();
        bitmap = BitmapFactory.decodeResource(getResources(), id:R.drawable.fcq_logo);
        bitmapEscala = Bitmap.createScaledBitmap(bitmap,dstWidth:80,dstHeight:80,filter: false);
        canvas.drawBitmap(bitmapEscala,left:368,top:20, paint);

        titulo.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        titulo.setTextSize(20);
        canvas.drawText(tituloText, x:10, y:150,titulo);

        descripcion.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        descripcion.setTextSize(14);

        String[] arrDescripcion = descripcionText.split(regex:"\n");
        int y =200;
        for(int i = 0; i < arrDescripcion.Length; i++) {
            canvas.drawText(arrDescripcion[i], x:10,y, descripcion);
            y += 15;
        }
        pdfDocument.finishPage(Pagina1);

        File File = new File(Environment.getExternalStorageDirectory(), child: "Archivo.pdf");
        try {
            pdfDocument.writeTo(new FileOutputStream(file));
            Toast.makeText(context: this, text: "se creo el pdf correctamente", Toast.LENGTH_LONG).show();
        }catch(Exception e) {
            e.printStackTrace();
        }
        pdfDocument.close();
    }
  private boolean checkPermission(){
        int permission1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int permission2 = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED;
  }
  private void requestPermissions(){
      ActivityCompat.requestPermissions(activity:this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, requestCode: 200);
}
@Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]grandResults){
    if(requestCode == 200) {
        if (grantResults.length > 0) {
            boolean writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
            boolean writeStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;

            if(writeStorage && roadStorage){
                _Toast.makeText(context: this, text:"Permiso concedido", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(context: this,text: "Permiso denegado", Toast.LENGTH_LONG).show();
        }
    }
}
}
}

