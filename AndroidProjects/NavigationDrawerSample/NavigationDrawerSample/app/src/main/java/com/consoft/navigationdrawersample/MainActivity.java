package com.consoft.navigationdrawersample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle mDrawerToggle;//il DrawerToggle mi serve per intercettare il click sul bottone home dell'actionBar
    DrawerLayout mDrawerLayout; //il DrawerLayout contine tutto l'oggetto grafico DrawerLayout del layout e serve per gestirlo


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.closeDrawers();
        LinearLayout lLinear1,lLinear2,lLinear3,lLinear4,lLinear5;


        setUpDrawerToggle();//metodo creato da noi per la gestione del DrawerToggle


        BlankFragment vFragment = new BlankFragment();//creo un fragment custom (ho creato io la classe BlankFragment)
        FragmentManager vManager = getSupportFragmentManager();//recupero il fragment manager (support o no) in maniera da poter gestire i fragment
        FragmentTransaction vTransaction = vManager.beginTransaction();//mi tiro fuori una FragmentTransaction in modo da poter gestire una transizione di un fragment
        vTransaction.add(R.id.container,vFragment, "TAG");//faccio l'add del fragment indicando il suo contenitore e un tag di riferimento al fragment stesso oltre che il fragment
        vTransaction.commit();//committo eseguendo la transizione

        lLinear1 = (LinearLayout) findViewById(R.id.Linear1);
        lLinear2 = (LinearLayout) findViewById(R.id.Linear2);
        lLinear3 = (LinearLayout) findViewById(R.id.Linear3);
        lLinear4 = (LinearLayout) findViewById(R.id.Linear4);
        lLinear5 = (LinearLayout) findViewById(R.id.Linear5);

        lLinear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiaFramework(1);
            }
        });

        lLinear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiaFramework(2);
            }
        });

        lLinear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiaFramework(3);
            }
        });

        lLinear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiaFramework(4);
            }
        });

        lLinear5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiaFramework(5);
            }
        });


    }

    private void setUpDrawerToggle() {
        ActionBar actionBar = getSupportActionBar();//recupero la mia ActionBar support oppure no

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        //rendo abilitato il bottone home della actionBar

        mDrawerToggle = new ActionBarDrawerToggle(
                this,

                mDrawerLayout,
                R.string.app_name,
                R.string.app_name
        ) {//istanzio il DrawerToggle
            @Override
            public void onDrawerClosed(View drawerView) {
                invalidateOptionsMenu(); // cito chi lo spiega meglio di me: invalidateOptionsMenu() is used to say Android, that contents of menu have changed, and menu should be redrawn. For example, you click a button which adds another menu item at runtime, or hides menu items group
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
        });//serve per sincronizzare il menù
        mDrawerLayout.setDrawerListener(mDrawerToggle);//assegno al drawerlayout il suo drawertoggle
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //l'override di questo metodo serve per intercettare il click sulla actionbar in modo da passarlo al drawertoggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void cambiaFramework (int n){
        Fragment vFragment = null;
        switch (n){
            case 1:
                Fragment1 vFragment1 = new Fragment1();
                FragmentManager vManager1 = getSupportFragmentManager();
                FragmentTransaction vTransaction1 = vManager1.beginTransaction();
                vTransaction1.replace(R.id.container,vFragment1, "TAG");
                vTransaction1.commit();
                break;
            case 2:
                Fragment2 vFragment2 = new Fragment2();
                FragmentManager vManager2 = getSupportFragmentManager();
                FragmentTransaction vTransaction2 = vManager2.beginTransaction();
                vTransaction2.replace(R.id.container,vFragment2, "TAG");
                vTransaction2.commit();
                break;
            case 3:
                Fragment3 vFragment3 = new Fragment3();
                FragmentManager vManager3 = getSupportFragmentManager();
                FragmentTransaction vTransaction3 = vManager3.beginTransaction();
                vTransaction3.replace(R.id.container,vFragment3, "TAG");
                vTransaction3.commit();
                break;
            case 4:
                Fragment4 vFragment4 = new Fragment4();
                FragmentManager vManager4 = getSupportFragmentManager();
                FragmentTransaction vTransaction4 = vManager4.beginTransaction();
                vTransaction4.replace(R.id.container,vFragment4, "TAG");
                vTransaction4.commit();
                break;
            case 5:
                Fragment5 vFragment5 = new Fragment5();
                FragmentManager vManager5 = getSupportFragmentManager();//recupero il fragment manager (support o no) in maniera da poter gestire i fragment
                FragmentTransaction vTransaction5 = vManager5.beginTransaction();//mi tiro fuori una FragmentTransaction in modo da poter gestire una transizione di un fragment
                vTransaction5.replace(R.id.container,vFragment5, "TAG");//faccio l'add del fragment indicando il suo contenitore e un tag di riferimento al fragment stesso oltre che il fragment
                vTransaction5.commit();
                break;
        }
    }
}


