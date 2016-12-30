package com.example.utente.navigationdrawer;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tText;
    LinearLayout lKey1,lKey2,lKey3,lKey4,lKey5;
    ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);



        tText = (TextView) findViewById(R.id.textViewKey);

        lKey1= (LinearLayout) findViewById(R.id.Key1);
        lKey2= (LinearLayout) findViewById(R.id.Key2);
        lKey3= (LinearLayout) findViewById(R.id.Key3);
        lKey4= (LinearLayout) findViewById(R.id.Key4);
        lKey5= (LinearLayout) findViewById(R.id.Key5);

        setUpDrawerToggle();

        lKey1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tText.setText("You press the button 1");
            }
        });

        lKey2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tText.setText("You press the button 2");
            }
        });

        lKey3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tText.setText("You press the button 3");
            }
        });

        lKey4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tText.setText("You press the button 4");
            }
        });

        lKey5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tText.setText("You press the button 5");
            }
        });
    }

    private void setUpDrawerToggle() {
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle (
            this,
            mDrawerLayout,
            R.string.app_name,
            R.string.app_name
            ) {
         @Override
                 public void onDrawerClosed(View drawerView){
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView){
                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        if (mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
