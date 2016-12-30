package com.its.samuele.esameandroid;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements Fragment0.IFragment0, DialogFragment0.IDialogFragment0 {

    TextView tvActivity;
    Button bSetFragmentText;
    Fragment0 fFragment;
    FragmentManager vManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvActivity = (TextView) findViewById(R.id.textViewFragment);

        bSetFragmentText = (Button) findViewById(R.id.buttonActivity);

        vManager = getFragmentManager();

        if (savedInstanceState==null){
            fFragment=new Fragment0();
            FragmentTransaction vTransaction = vManager.beginTransaction();
            vTransaction.add(R.id.container,fFragment,"tag");
            vTransaction.commit();
        }
        else {
            fFragment = (Fragment0) vManager.findFragmentByTag("tag");
        }

        bSetFragmentText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fFragment.setFragmentText("premuto activity");
            }
        });



    }

    @Override
    public void setTextActivity(String s) {
        tvActivity.setText(s);
    }

    @Override
    public void launchDialog() {
        FragmentManager fm = getFragmentManager();
        DialogFragment0 vDialog = new DialogFragment0();
        vDialog.show(fm, "");
    }


    @Override
    public void onNegativeClick() {

    }

    @Override
    public void onPosativeClick() {

    }

    @Override
    public void onNeutralClick() {

    }

    @Override
    public void changeActivity() {
        Intent vIntent = new Intent(this,Main2Activity.class);
        startActivity(vIntent);
    }
}
