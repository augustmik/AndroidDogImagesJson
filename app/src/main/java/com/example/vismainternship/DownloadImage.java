package com.example.vismainternship;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.InputStream;

public class DownloadImage extends AsyncTask<String,Void, Bitmap> {

    ImageView imageView;

    public DownloadImage (ImageView imageView){
        this.imageView = imageView;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap bmp = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            bmp = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return bmp;
    }
    protected void onPostExecute(Bitmap result) {
        //Log.i("imageWidth", Integer.toString(result.getWidth()) + imageView.getLayoutParams().width);
        //imageView.getLayoutParams().width = result.getWidth();
        //imageView.getLayoutParams().width = result.getWidth();
        //imageView.requestLayout();
        //imageView.getLayoutParams().height = result.getHeight();
        //imageView.getLayoutParams().width = result.getWidth();
        //imageView.setMaxHeight(result.getHeight());
        //imageView.setMaxWidth(result.getWidth());
        //imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        imageView.setImageBitmap(result);

    }
}
