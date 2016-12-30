package com.its.pretto.samuele.picassoexample;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Picasso.with(this)
                .load("https://wallpaperscraft.com/image/art_star_tree_sky_space_93472_3840x2160.jpg")
                .placeholder(R.drawable.noimageavailable)
                .into(imageView);

    }
}
