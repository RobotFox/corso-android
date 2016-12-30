package com.example.utente.esercizio18022016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button plus;
    TextView conteggio;
    Button minus;
    int variabile=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conteggio = (TextView) findViewById(R.id.textView);
        plus = (Button) findViewById(R.id.buttonplus);
        minus = (Button) findViewById(R.id.buttonminus);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variabile++;
                conteggio.setText(Integer.toString(variabile));
            }
        });

        minus.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if (variabile>0){
                    variabile--;
                    conteggio.setText(variabile+"");
                }
                conteggio.setText(variabile+"");
            }
        });
    }
}
