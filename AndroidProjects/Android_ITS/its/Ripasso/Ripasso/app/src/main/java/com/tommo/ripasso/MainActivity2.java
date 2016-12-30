package com.tommo.ripasso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView mTextView;
    int mCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTextView = (TextView) findViewById(R.id.textView);
        if (getIntent().getExtras() != null) {//controllo che nell'intent da cui provengo sia presente un bundle
            mCounter = getIntent().getExtras().getInt(MainActivity.COUNTER);//estraggo da quel bundle il mio valore
        } else {
            mCounter = 0;//se non ho nessun bundle nell'intent metto mCounter=0
        }
        mTextView.setText(Integer.toString(mCounter));//metto a sulla textview in modo che si veda a display il valore di mCounter
    }
}
