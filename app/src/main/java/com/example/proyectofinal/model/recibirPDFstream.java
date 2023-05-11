package com.example.proyectofinal.model;

import andorid.os.AsyncTask

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.oi.InputStream
import java.net.URL

public class recibirPDFstream extends AsyncTask <String,Void,ImputStream> {

   PDFView pdfView;
   ProgressBar progressBar;

   public recibirPDFstream(PDFView pdfView, ProgressBar progressBar){
       this.pdfView = pdfView;
       this.progressBar = progressBar;
   }
    @Override
    protected ImputStream doInBackground(String... strings) {
        ImputStream imputStream = null;
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection URLConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == 200) {
                imputStream = new BufferedInputStream(urlConnection.getInputStream());
            }
        } catch (IDException e) {
            return null;
        }
        return inputStream;
    }
    @Override
    protected void onPostExecute(InputStream imputStream){
        pdfView.fromStream(imputStream).load();
        progressBar.setVisibility(View.GONE);

    }
}
