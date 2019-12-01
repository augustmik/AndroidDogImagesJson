package com.example.vismainternship;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CreateViews {

    private int amount;

    public CreateViews (int amount){
        this.amount = amount;
    }

    public void Creation(LinearLayout linL, Context context, JsonClass jData){
        for (int i=0; i<amount; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setAdjustViewBounds(true);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            imageView.setImageResource(R.drawable.ic_launcher_background);
            linL.addView(imageView);

            new DownloadImage(imageView).execute(jData.urls.get(i));
        }
    }
}
