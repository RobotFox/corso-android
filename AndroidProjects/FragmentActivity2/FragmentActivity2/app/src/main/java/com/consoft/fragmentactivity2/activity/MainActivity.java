package com.consoft.fragmentactivity2.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.consoft.fragmentactivity2.R;
import com.consoft.fragmentactivity2.fragment.MyFragment;
import com.consoft.fragmentactivity2.fragment.NewFragment;

public class MainActivity extends Activity implements MyFragment.IMyFragment, NewFragment.INewFragment/*implemento l'interfaccia creata nel fragment*/ {
    Button mButton;
    TextView mTextView;
    MyFragment vFragment;
    FragmentManager vManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.buttonActivity);
        mTextView = (TextView) findViewById(R.id.textViewActivity);


        vManager = getFragmentManager();

        if (savedInstanceState == null) {//controllo per capire se è la prima volta che creo l'activity
            vFragment = new MyFragment();//se è la prima volta creo il fragment e lo aggiungo
            FragmentTransaction vTansaction = vManager.beginTransaction();
            vTansaction.add(R.id.container, vFragment, "tag");
            vTansaction.commit();
        } else {
            vFragment = (MyFragment) vManager.findFragmentByTag("tag");//se l'activity era gia stata creata recupero il fragment attraverso il tag
        }

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vFragment.setLabelFragment("premuto activity");// chiamo il metodo del fragment in maniera da poter manipolare il contenuto dello stesso
            }
        });
    }

    @Override//faccio l'override deòl metodo dell'interfaccia: questo sarà il metodo che viene chiamato dal fragment
    public void setLabelActivity(String aLabel) {
        mTextView.setText(aLabel);
    }

    @Override
    public void changeFragment() {

        NewFragment vFragment = new NewFragment();
        FragmentTransaction vTransaction = vManager.beginTransaction();
        vTransaction.replace(R.id.container,vFragment,"Tag2");
        vTransaction.commit();

    }

    @Override
    public void changeFragment2() {
        MyFragment vFragment = new MyFragment();
        FragmentTransaction vTransaction = vManager.beginTransaction();
        vTransaction.replace(R.id.container,vFragment,"Tag3");
        vTransaction.commit();
    }
}
