package com.its.pretto.samuele.webvideoexample;

import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnFromFile,btnFromLink;

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFromFile = (Button) findViewById(R.id.buttonFromLocale);
        btnFromLink = (Button) findViewById(R.id.buttonFromLink);

        final String path = "android.resource://"+getPackageName()+"/"+R.raw.blue;

        webView = (WebView) findViewById(R.id.webViewActivity);
        btnFromFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textHtml = "<video width=\"320\" height=\"240\" controls>\n" +
                        "  <source src="+path+".mp4\" type=\"video/mp4\">\n" +
                        "  <source src="+path+".ogg\" type=\"video/ogg\">\n" +
                        "Your browser does not support the video tag.\n" +
                        "</video>";
                webView.loadData(textHtml,"text/html","charset=UTF-8");
            }
        });

        btnFromLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://ia800403.us.archive.org/17/items/electricsheep-flock-247-5000-1/00247=05011=05011=05011.mp4");
                
            }
        });

    }
}
