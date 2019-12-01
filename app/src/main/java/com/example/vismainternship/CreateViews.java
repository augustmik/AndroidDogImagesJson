package com.example.vismainternship;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CreateViews {

    private int amount;
    private ImageView fView;

    public CreateViews (int amount, ImageView fView){
        this.amount = amount;
        this.fView = fView;
    }

    public void Creation(LinearLayout linL, Context context, JsonClass jData){
        for (int i=0; i<amount; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setAdjustViewBounds(true);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            imageView.setImageResource(R.drawable.ic_launcher_background);

            imageView.setClickable(true); //BONUS
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ViewClick(v);
                }
            });

            linL.addView(imageView);

            new DownloadImage(imageView).execute(jData.urls.get(i));
        }
    }
    private void ViewClick(View view){
        Log.i("ClickedCheck", "I clicked" + view.toString());

        ImageView v = (ImageView) view;
        Bitmap bm=((BitmapDrawable) v.getDrawable()).getBitmap();
        fView.setImageBitmap(bm);
        fView.setVisibility(View.VISIBLE);
        fView.bringToFront();
        fView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FClick(v);
            }
        });
    }
    private void FClick(View view){
        fView.setVisibility(View.GONE);
    }
}
