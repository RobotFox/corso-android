package com.its.pretto.samuele.esame14102016;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Samuele.Pretto on 14/10/2016.
 */

public class CloseFragment extends Fragment {

    Button btnClose;

    public interface ICloseFragment {
        public void OnClose();
    }

    ICloseFragment listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_close,container,false);
        btnClose = (Button) view.findViewById(R.id.buttonClose);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnClose();
            }
        });


        return view;
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
