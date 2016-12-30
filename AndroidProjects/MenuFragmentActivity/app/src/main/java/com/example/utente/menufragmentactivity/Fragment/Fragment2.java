package com.example.utente.menufragmentactivity.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.utente.menufragmentactivity.R;

/**
 * Created by Utente on 22/04/2016.
 */
public class Fragment2 extends Fragment {

    TextView fTexrViewFragment;
    Button fButtonNext;
    Fragment vFragment;
    FragmentManager vManager1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vView = inflater.inflate(R.layout.fragment2,container,false);

        fTexrViewFragment = (TextView) vView.findViewById(R.id.textViewFragment);
        fButtonNext = (Button) vView.findViewById(R.id.buttonNext);

        fButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vFragment= new Fragment3();
                vManager1 = getFragmentManager();
                FragmentTransaction vTransaction1 = vManager1.beginTransaction();
                vTransaction1.replace(R.id.container,vFragment, "TAG");
                vTransaction1.commit();
            }
        });


        return vView;
    }
}
