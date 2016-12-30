package com.its.pretto.samuele.esame11112016.activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.VideoView;

import com.its.pretto.samuele.esame11112016.R;

public class Activity5 extends AppCompatActivity {

    VideoView videoView;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        videoView = (VideoView) findViewById(R.id.videoView);
        webView = (WebView) findViewById(R.id.webView);

        videoView.setVideoURI(Uri.parse("https://ia800403.us.archive.org/17/items/electricsheep-flock-247-5000-1/00247=05011=05011=05011.mp4"));
        videoView.start();

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://ia800403.us.archive.org/17/items/electricsheep-flock-247-5000-1/00247=05011=05011=05011.mp4");

    }
}
