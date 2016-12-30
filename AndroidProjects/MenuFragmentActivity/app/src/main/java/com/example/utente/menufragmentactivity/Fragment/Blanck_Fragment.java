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
    IFragment0 mListener;

    public interface IFragment0{
        public void changeFragment1();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vView = inflater.inflate(R.layout.blanck_activity,container,false);
        fTextViewFragment = (TextView) vView.findViewById(R.id.textViewFragment);
        fButtonNext = (Button) vView.findViewById(R.id.buttonNext);

        fButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               mListener.changeFragment1();
            }
        });
        return vView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof IFragment0){
            mListener= (IFragment0) activity;
        }
        else {
            mListener=null;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}