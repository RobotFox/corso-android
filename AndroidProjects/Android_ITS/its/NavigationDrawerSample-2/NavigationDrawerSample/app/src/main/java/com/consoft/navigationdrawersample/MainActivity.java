package com.consoft.navigationdrawersample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle mDrawerToggle;//il DrawerToggle mi serve per intercettare il click sul bottone home dell'actionBar
    DrawerLayout mDrawerLayout; //il DrawerLayout contine tutto l'oggetto grafico DrawerLayout del layout e serve per gestirlo


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        setUpDrawerToggle();//metodo creato da noi per la gestione del DrawerToggle


        BlankFragment vFragment = new BlankFragment();//creo un fragment custom (ho creato io la classe BlankFragment)
        FragmentManager vManager = getSupportFragmentManager();//recupero il fragment manager (support o no) in maniera da poter gestire i fragment
        FragmentTransaction vTransaction = vManager.beginTransaction();//mi tiro fuori una FragmentTransaction in modo da poter gestire una transizione di un fragment
        vTransaction.add(R.id.container,vFragment, "TAG");//faccio l'add del fragment indicando il suo contenitore e un tag di riferimento al fragment stesso oltre che il fragment
        vTransaction.commit();//committo eseguendo la transizione
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
}
