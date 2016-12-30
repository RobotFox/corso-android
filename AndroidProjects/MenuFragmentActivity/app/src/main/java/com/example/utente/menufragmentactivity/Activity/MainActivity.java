package com.example.utente.menufragmentactivity.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.utente.menufragmentactivity.Fragment.Blanck_Fragment;
import com.example.utente.menufragmentactivity.Fragment.Fragment1;
import com.example.utente.menufragmentactivity.Fragment.Fragment2;
import com.example.utente.menufragmentactivity.Fragment.Fragment3;
import com.example.utente.menufragmentactivity.Fragment.Fragment4;
import com.example.utente.menufragmentactivity.R;

public class MainActivity extends AppCompatActivity implements Fragment1.IFragment1, Blanck_Fragment.IFragment0 {
    ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout mDrawerLayout;
    LinearLayout mLinearLayout1, mLinearLayout2, mLinearLayout3, mLinearLayout4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);


        setUpDrawerToggle();

        FragmentManager vManager = getFragmentManager();
        if (savedInstanceState==null){

            Blanck_Fragment sFragment = new Blanck_Fragment();
            FragmentTransaction vTransaction = vManager.beginTransaction();
            vTransaction.add(R.id.container, sFragment, "TAG");
            vTransaction.commit();
        }

        else{
            vManager.findFragmentByTag("TAG");
        }


        mLinearLayout1 = (LinearLayout) findViewById(R.id.Linear1);

        mLinearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeFragment(1);
                mDrawerLayout.closeDrawers();
            }
        });

        mLinearLayout2 = (LinearLayout) findViewById(R.id.Linear2);

        mLinearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeFragment(2);
                mDrawerLayout.closeDrawers();
            }
        });

        mLinearLayout3 = (LinearLayout) findViewById(R.id.Linear3);

        mLinearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeFragment(3);
                mDrawerLayout.closeDrawers();
            }
        });

        mLinearLayout4 = (LinearLayout) findViewById(R.id.Linear4);

        mLinearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeFragment(4);
                mDrawerLayout.closeDrawers();
            }
        });


    }

    private void setUpDrawerToggle() {
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,

                mDrawerLayout,
                R.string.app_name,
                R.string.app_name
        )
        {
            @Override
            public void onDrawerClosed(View drawerView) {
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
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
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void changeFragment (int n){
        switch (n){
            case 1:
                Fragment1 vFragment1 = new Fragment1();
                FragmentManager vManager1 = getFragmentManager();
                FragmentTransaction vTransaction1 = vManager1.beginTransaction();
                vTransaction1.replace(R.id.container,vFragment1, "TAG");
                vTransaction1.commit();
                break;
            case 2:
                Fragment2 vFragment2 = new Fragment2();
                FragmentManager vManager2 = getFragmentManager();
                FragmentTransaction vTransaction2 = vManager2.beginTransaction();
                vTransaction2.replace(R.id.container,vFragment2, "TAG");
                vTransaction2.commit();
                break;
            case 3:
                Fragment3 vFragment3 = new Fragment3();
                FragmentManager vManager3 = getFragmentManager();
                FragmentTransaction vTransaction3 = vManager3.beginTransaction();
                vTransaction3.replace(R.id.container,vFragment3, "TAG");
                vTransaction3.commit();
                break;
            case 4:
                Fragment4 vFragment4 = new Fragment4();
                FragmentManager vManager4 = getFragmentManager();
                FragmentTransaction vTransaction4 = vManager4.beginTransaction();
                vTransaction4.replace(R.id.container,vFragment4, "TAG");
                vTransaction4.commit();
                break;
        }
    }

    @Override
    public void changeFragment1() {
        Fragment1 vFragment1 = new Fragment1();
        FragmentManager vManager1 = getFragmentManager();
        FragmentTransaction vTransaction1 = vManager1.beginTransaction();
        vTransaction1.replace(R.id.container,vFragment1, "TAG");
        vTransaction1.commit();
    }

    @Override
    public void changeFragment0() {
        Blanck_Fragment vFragment0 = new Blanck_Fragment();
        FragmentManager vManager0 = getFragmentManager();
        FragmentTransaction vTransaction0 = vManager0.beginTransaction();
        vTransaction0.replace(R.id.container,vFragment0, "TAG");
        vTransaction0.commit();
    }
}

