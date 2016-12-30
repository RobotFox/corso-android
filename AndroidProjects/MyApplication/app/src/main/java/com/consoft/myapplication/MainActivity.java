package com.consoft.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    TextView mNumeroPartecipanti;
    Button mPlus, mMenus;
    int mCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumeroPartecipanti = (TextView) findViewById(R.id.textView);
        mPlus = (Button) findViewById(R.id.button);
        mMenus = (Button) findViewById(R.id.button2);

        mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter++;
                mNumeroPartecipanti.setText(mCounter+"");
            }
        });
        mMenus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter--;
                if(mCounter<=0){
                    mCounter=0;
                }
                mNumeroPartecipanti.setText(Integer.toString(mCounter));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
