package com.joooonho;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView.ScaleType;

import com.squareup.picasso.Picasso;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // All properties can be set in xml.
        SelectableRoundedImageView iv0 = (SelectableRoundedImageView) findViewById(R.id.image0);
        
        // You can set image with resource id.
        SelectableRoundedImageView iv1 = (SelectableRoundedImageView) findViewById(R.id.image1);
        iv1.setScaleType(ScaleType.CENTER_CROP);
        iv1.setOval(true);
        iv1.setImageResource(R.drawable.photo_cheetah);
        
        // Also, You can set image with Picasso.
        // This is a normal rectangle imageview.
        SelectableRoundedImageView iv2 = (SelectableRoundedImageView) findViewById(R.id.image2);
        iv1.setScaleType(ScaleType.CENTER);
        Picasso.with(this).load(R.drawable.photo2).into(iv2);
        
        // Of course, you can set round radius in code.
        SelectableRoundedImageView iv3 = (SelectableRoundedImageView) findViewById(R.id.image3);
        iv3.setImageDrawable(getResources().getDrawable(R.drawable.photo3));
        ((SelectableRoundedImageView)iv3).setCornerRadiusesDP(4, 4, 0, 0);
        
    }
}
