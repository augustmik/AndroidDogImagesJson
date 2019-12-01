package com.example.vismainternship;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.InputStream;

public class DownloadImage extends AsyncTask<String,Void, Bitmap> { //Downloads and sets images to already created imageViews

    private ImageView imageView;

    public DownloadImage (ImageView imageView){
        this.imageView = imageView;
    }

    protected Bitmap doInBackground(String... urls) {
        String url = urls[0];
        Bitmap bmp = null;
        try {
            InputStream in = new java.net.URL(url).openStream();
            bmp = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("InputStreamError", e.getMessage());
            e.printStackTrace();
        }
        return bmp;
    }
    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
    }
}
