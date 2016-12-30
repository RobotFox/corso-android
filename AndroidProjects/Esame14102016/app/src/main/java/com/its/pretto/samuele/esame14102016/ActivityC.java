package com.its.pretto.samuele.esame14102016;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityC extends AppCompatActivity implements CloseFragment.ICloseFragment{

    CloseFragment closeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        if (savedInstanceState == null){
            closeFragment = new CloseFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.container, closeFragment, "close");
            transaction.commit();
        }
    }

    @Override
    public void OnClose() {
        super.onBackPressed();
    }
}
