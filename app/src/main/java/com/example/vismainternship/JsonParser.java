package com.example.vismainternship;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class JsonParser {

    private JsonClass url;

    public JsonClass loadJSONFromAssets(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("DogsJson");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        //Log.i("Check", json);

        JsonClass jsonA = JsonS2Array(json);

        return jsonA;
    }
    private JsonClass JsonS2Array(String jsonS) {
        url = new Gson().fromJson( jsonS, JsonClass.class);
        return url;
    }
}
