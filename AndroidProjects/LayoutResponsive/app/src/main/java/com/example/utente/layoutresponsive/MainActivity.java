package com.example.utente.layoutresponsive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button mPlus,mMinus;
    TextView mDisplay;
    int mCounter;
    Button mChangeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pippo_layout);
        mDisplay= (TextView) findViewById(R.id.textViewCounterDisplay);
        mCounter=0;
        mChangeActivity= (Button) findViewById(R.id.buttonchange);
        if (savedInstanceState!=null){
            mCounter=savedInstanceState.getInt("NUM");
            mDisplay.setText(Integer.toString(mCounter));
        }
        mPlus= (Button) findViewById(R.id.buttonplus);
        mMinus= (Button) findViewById(R.id.buttonminus);

        mDisplay.setText(Integer.toString(mCounter));


        mChangeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vIntent=new Intent(MainActivity.this,Main2Activity.class);
                Bundle vBundle = new Bundle();
                vBundle.putInt("NUM",mCounter);
                vIntent.putExtras(vBundle);
                startActivity(vIntent);


            }
        });

        mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCounter>=0){
                    mCounter++;
                    mDisplay.setText(Integer.toString(mCounter));
                }
                else{
                    mCounter=0;
                    mDisplay.setText(Integer.toString(mCounter));
                }


            }
        });
        mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCounter>=0){
                    mCounter--;
                    mDisplay.setText(Integer.toString(mCounter));
                }
                else{
                    mCounter=0;
                    mDisplay.setText(Integer.toString(mCounter));
                }

            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("NUM",mCounter);
    }
}
