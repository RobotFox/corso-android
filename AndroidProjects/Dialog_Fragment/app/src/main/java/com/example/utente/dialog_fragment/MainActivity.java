package com.example.utente.dialog_fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements DialogFragmentSample.ICustomDialogFragment {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text= (TextView) findViewById(R.id.textView);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                //DialogFragmentSample dialogFragment = new DialogFragmentSample("Lorem ipsum","Fragment 1");

                DialogFragmentSample vDialog = new DialogFragmentSample();
                Bundle vBundle = new Bundle();
                vBundle.putString("MES","message");
                vBundle.putString("TIT","title");
                vDialog.setArguments(vBundle);
                vDialog.show(fm, "Dialog Fragment is here!");
            }
        });




    }

    public void setText(String s) {
        text.setText(s);
    }

    @Override
    public void onNegativeClick() {
        text.setText("Negative");
    }

    @Override
    public void onPosativeClick() {
    text.setText("Positive");
    }

    @Override
    public void onNeutralClick() {
    text.setText("Neutral");
    }
}
