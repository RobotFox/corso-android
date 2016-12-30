package com.example.utente.calcolatricenew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    TextView cronologia;
    String operazioni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cronologia = (TextView) findViewById(R.id.textView);
        Intent i= getIntent();
        Bundle extras= i.getExtras();

        operazioni= extras.getString("CRONO");
        cronologia.setText(operazioni);


    }
}
