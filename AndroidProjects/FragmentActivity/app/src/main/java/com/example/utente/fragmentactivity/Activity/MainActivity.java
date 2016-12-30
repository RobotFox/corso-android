package com.example.utente.fragmentactivity.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.utente.fragmentactivity.Fragment.MyFragment;
import com.example.utente.fragmentactivity.R;

public class MainActivity extends Activity implements MyFragment.IMyFragment{

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

        if (savedInstanceState==null){
            vFragment=new MyFragment();
            FragmentTransaction vTransaction = vManager.beginTransaction();
            vTransaction.add(R.id.container,vFragment,"tag");
            vTransaction.commit();
        }
        else {
            vFragment = (MyFragment) vManager.findFragmentByTag("tag");
        }

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFragment.setLabelFragment("premuto activity");
            }
        });
    }

    @Override
    public void setLabelActivity(String label) {
        mTextView.setText(label);
    }
}
