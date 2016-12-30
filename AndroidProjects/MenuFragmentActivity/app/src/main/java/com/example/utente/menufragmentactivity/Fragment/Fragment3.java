package com.example.utente.menufragmentactivity.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.utente.menufragmentactivity.R;

/**
 * Created by Utente on 22/04/2016.
 */
public class Fragment3 extends Fragment {

    TextView tTextViewFragment;
    Button bButtonNext;
    Fragment vFragment;
    FragmentManager vManager1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vView = inflater.inflate(R.layout.fragment3,container,false);

        tTextViewFragment = (TextView) vView.findViewById(R.id.textViewFragment);
        bButtonNext = (Button) vView.findViewById(R.id.buttonNext);

        bButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vFragment= new Fragment4();
                vManager1 = getFragmentManager();
                FragmentTransaction vTransaction1 = vManager1.beginTransaction();
                vTransaction1.replace(R.id.container,vFragment, "TAG");
                vTransaction1.commit();
            }
        });

        return vView;
    }
}
