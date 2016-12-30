package com.example.utente.tictactoenew;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView title;
    Typeface myCustomFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.textViewTitle);
        myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/test.ttf");
        title.setTypeface(myCustomFont);
    }
}
