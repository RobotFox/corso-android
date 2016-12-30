package com.its.pretto.samuele.esame;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Samuele.Pretto on 25/10/2016.
 */

public class CloseFragment extends Fragment {

    Button btnClose;

    public interface ICloseFragment{
        public void onClose();
    }

    ICloseFragment listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_close,container,false);

        btnClose = (Button) rootView.findViewById(R.id.buttonClose);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClose();
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ICloseFragment){
            listener = (ICloseFragment) activity;
        }
        else {
            listener = null;
        }
    }
}
