
package com.example.utente.esercizioorizzontale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button plus;
    Button minus;
    int variabile=0;
    TextView contatore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus= (Button)findViewById(R.id.buttonplus);
        minus = (Button) findViewById(R.id.buttonminus);
        contatore = (TextView) findViewById(R.id.textView);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variabile++;
                contatore.setText(Integer.toString(variabile));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (variabile >0){
                    variabile--;
                    contatore.setText(Integer.toString(variabile));
                }
                else{
                    variabile=0;
                    contatore.setText(Integer.toString(variabile));
                }

            }
        });
    }
}
