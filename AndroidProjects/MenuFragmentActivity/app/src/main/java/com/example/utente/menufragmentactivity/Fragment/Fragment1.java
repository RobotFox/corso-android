package com.example.utente.menufragmentactivity.Fragment;

import android.app.Activity;
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
 * Created by Utente on 21/04/2016.
 */
public class Fragment1 extends Fragment {

    TextView fTextViewFragment;
    Button fButtonNext;
    Fragment vFragment;
    FragmentManager vManager1;
    IFragment1 mListener;


    public interface IFragment1{
        public void changeFragment0();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vView = inflater.inflate(R.layout.fragment1,container,false);

        fTextViewFragment = (TextView) vView.findViewById(R.id.textViewFragment);
        fButtonNext = (Button) vView.findViewById(R.id.buttonNext);

        fButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.changeFragment0();
            }
        });


        return vView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof IFragment1){
            mListener= (IFragment1) activity;
        }
        else {
            mListener = null;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
