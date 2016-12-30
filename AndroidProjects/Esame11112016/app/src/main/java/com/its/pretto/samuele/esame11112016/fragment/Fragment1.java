package com.its.pretto.samuele.esame11112016.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.its.pretto.samuele.esame11112016.R;

/**
 * Created by Samuele.Pretto on 11/11/2016.
 */

public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1,container,false);
        return rootView;
    }
}
