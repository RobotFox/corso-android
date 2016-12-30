package com.its.pretto.samuele.esame11112016.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.its.pretto.samuele.esame11112016.fragment.Fragment1;
import com.its.pretto.samuele.esame11112016.fragment.Fragment2;
import com.its.pretto.samuele.esame11112016.R;

public class Activity1 extends AppCompatActivity {

    Button btnFragment1, btnFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        btnFragment1 = (Button) findViewById(R.id.buttonFragment1);
        btnFragment2 = (Button) findViewById(R.id.buttonFragment2);

        btnFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.container,new Fragment1()).commit();
            }
        });

        btnFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.container,new Fragment2()).commit();
            }
        });
    }
}
