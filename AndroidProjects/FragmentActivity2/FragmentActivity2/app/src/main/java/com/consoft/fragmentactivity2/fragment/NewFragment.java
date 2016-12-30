package com.consoft.fragmentactivity2.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.consoft.fragmentactivity2.R;

/**
 * Created by Utente on 28/04/2016.
 */
public class NewFragment extends Fragment {

    Button mButton;
    INewFragment mListener;

    public interface INewFragment{
        public void changeFragment2();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vView = inflater.inflate(R.layout.fragment_new_fragment, container,false);
        mButton = (Button) vView.findViewById(R.id.buttonChange);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.changeFragment2();
            }
        });
        return vView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof INewFragment){
            mListener = (INewFragment) activity;
        }
        else {
            mListener = null;
        }
    }
}
