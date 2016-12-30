package com.its.pretto.samuele.esame11112016.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.its.pretto.samuele.esame11112016.R;

public class MainActivity extends AppCompatActivity {

    Button btnActivity1, btnActivity2,btnActivity3,btnActivity4,btnActivity5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActivity1 = (Button) findViewById(R.id.buttonActivity1);
        btnActivity2 = (Button) findViewById(R.id.buttonActivity2);
        btnActivity3 = (Button) findViewById(R.id.buttonActivity3);
        btnActivity4 = (Button) findViewById(R.id.buttonActivity4);
        btnActivity5 = (Button) findViewById(R.id.buttonActivity5);

        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Activity1.class));
            }
        });

        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Activity2.class));
            }
        });

        btnActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Activity3.class));
            }
        });

        btnActivity4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Activity4.class));
            }
        });

        btnActivity5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Activity5.class));
            }
        });

    }
}
