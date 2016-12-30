package com.example.utente.menufragmentactivity.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.utente.menufragmentactivity.R;

/**
 * Created by Utente on 28/04/2016.
 */
public class Fragment0 extends android.app.Fragment {

    TextView fTextViewFragment;
    Button fButtonNext;
    IFragment mListener;

    public interface IFragment{
        public void changeFragment0(int n);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vView = inflater.inflate(R.layout.fragment,container,false);

        fTextViewFragment = (TextView) vView.findViewById(R.id.textViewFragment);

        fButtonNext = (Button) vView.findViewById(R.id.buttonNext);

        fButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return vView;
    }

    public Button getfButtonNext() {
        return fButtonNext;
    }

    public void setfButtonNext(Button fButtonNext) {
        this.fButtonNext = fButtonNext;
    }

    public TextView getfTextViewFragment() {
        return fTextViewFragment;
    }

    public void setfTextViewFragment(TextView fTextViewFragment) {
        this.fTextViewFragment = fTextViewFragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof IFragment){
            mListener = (IFragment) activity;
        }
        else {
            mListener=null;
        }
    }
}
