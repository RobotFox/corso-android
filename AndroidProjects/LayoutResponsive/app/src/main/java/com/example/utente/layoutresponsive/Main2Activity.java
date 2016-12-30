package com.example.utente.layoutresponsive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView mTextView;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTextView= (TextView) findViewById(R.id.textView);
        if (getIntent().getExtras()!=null){
            counter=getIntent().getExtras().getInt("NUM");

        }
        else {
            counter=0;
        }
        mTextView.setText(Integer.toString(counter));
    }
}
