package com.its.pretto.samuele.esame11112016.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.its.pretto.samuele.esame11112016.R;
import com.its.pretto.samuele.esame11112016.service.ServiceActivity4;

public class Activity4 extends AppCompatActivity {

    Button btnStartService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        btnStartService = (Button) findViewById(R.id.buttonStartService);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4.this,ServiceActivity4.class);
                startService(intent);
            }
        });
    }
}
