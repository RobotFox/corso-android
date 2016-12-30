package com.example.utente.menufragmentactivity.Fragment;

/**
 * Created by Utente on 27/04/2016.
 */
import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.utente.menufragmentactivity.Activity.MainActivity;
import com.example.utente.menufragmentactivity.R;


public class Blanck_Fragment extends Fragment {

    TextView fTextViewFragment;
    Button fButtonNext;
    Fragment vFragment;
    FragmentManager vManager1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vView = inflater.inflate(R.layout.blanck_activity,container,false);
        fTextViewFragment = (TextView) vView.findViewById(R.id.textViewFragment);
        fButtonNext = (Button) vView.findViewById(R.id.buttonNext);

        fButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vFragment= new Fragment1();
                vManager1 = getFragmentManager();
                FragmentTransaction vTransaction1 = vManager1.beginTransaction();
                vTransaction1.replace(R.id.container,vFragment, "TAG");
                vTransaction1.commit();
            }
        });
        return vView;
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }
}