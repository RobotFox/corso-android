package com.its.pretto.samuele.videoviewexample;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;

    Button btnFromFile,btnFromLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.videoView);
        btnFromFile = (Button) findViewById(R.id.buttonFromFile);
        btnFromLink = (Button) findViewById(R.id.buttonFromLink);
        MediaController mediaController = new MediaController(MainActivity.this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        btnFromFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.blue);
                videoView.start();
            }
        });

        btnFromLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               videoView.setVideoURI(Uri.parse("https://ia800403.us.archive.org/17/items/electricsheep-flock-247-5000-1/00247=05011=05011=05011.mp4"));
                videoView.start();
            }
        });
    }
}
