package com.example.vismainternship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    private Context context;
    private JsonParser jParser = new JsonParser();
    private JsonClass jData;
    private CreateViews createViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getBaseContext();
        setContentView(R.layout.activity_main);
        jData = jParser.loadJSONFromAssets(context); //jData.urls.get(0) ==  https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg etc.
        Log.i("sizeOfjData", Integer.toString(jData.urls.size()));
        //Log.i("readFirst", jData.urls.get(0));
        ImageView fView = findViewById(R.id.fullscreenImage);

        createViews = new CreateViews(jData.urls.size(), fView);
        LinearLayout linearLayout = findViewById(R.id.linearCont);
        createViews.Creation(linearLayout, context, jData);
    }

}

