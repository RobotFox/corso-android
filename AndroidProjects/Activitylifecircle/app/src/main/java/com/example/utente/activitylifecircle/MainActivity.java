package com.example.utente.activitylifecircle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mText;
    Button mButton;
    int mCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ALC", "onCreate");
        if(savedInstanceState!=null){
            mCounter=savedInstanceState.getInt("CONT");
        }
        else{
            mCounter=0;
        }

        mText = (TextView) findViewById(R.id.textView);
        mButton= (Button)findViewById(R.id.button);
        mText.setText(mCounter+"");
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter++;
                mText.setText(mCounter+"");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ALC", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ALC", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ALC", "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ALC", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ALC", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ALC", "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CONT", mCounter);
    }
}
