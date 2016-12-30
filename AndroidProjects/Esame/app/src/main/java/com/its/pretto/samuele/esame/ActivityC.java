package com.its.pretto.samuele.esame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityC extends AppCompatActivity implements CloseFragment.ICloseFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        if (savedInstanceState==null){
            getFragmentManager().beginTransaction().add(R.id.container,new CloseFragment()).commit();
        }
    }

    @Override
    public void onClose() {
        finish();
    }
}
