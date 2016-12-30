package com.example.utente.fragmentviewsample;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState==null){
            Fragment vFragment=new FragmentSample();
            FragmentManager vManager=getFragmentManager();
            FragmentTransaction vTransaction = vManager.beginTransaction();
            vTransaction.add(R.id.container,vFragment,"rag");
            vTransaction.commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("tag",true);
    }
}
