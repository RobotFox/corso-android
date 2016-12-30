package com.consoft.fragmentviewsample;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

    private static final String TAG = "Tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {//metto il fragment solo se è la prima volta che avvio l'activity, infatti il fragment resta se giriamo lo smartphone.
            Fragment vFragment = new FragmentSample();//creo il fragment
            FragmentManager vManager = getFragmentManager();//recupero il fragmentManager
            FragmentTransaction vTransaction = vManager.beginTransaction();//inizializzo una transazione
            vTransaction.add(R.id.container, vFragment, "tag");//faccio l'add del fragment
            vTransaction.commit();//faccio il commit della transazione
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(TAG, true);
    }
}
