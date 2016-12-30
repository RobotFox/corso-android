package com.its.samuele.esameandroid;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Utente on 12/05/2016.
 */
public class Fragment0 extends Fragment {

    TextView tvFragmentText;
    Button bSetActivityText;
    Button bChange;
    IFragment0 mListener;


    public interface IFragment0{
        public void setTextActivity (String s);
        public void launchDialog();

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vView = inflater.inflate(R.layout.fragment_layout,container,false);

        tvFragmentText = (TextView) vView.findViewById(R.id.textViewActivity);
        bSetActivityText = (Button) vView.findViewById(R.id.buttonFragment);
        bChange = (Button) vView.findViewById(R.id.buttonChange);

        bSetActivityText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.setTextActivity("premuto fragment");
            }
        });

        bChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.launchDialog();
            }
        });


        return vView;
    }
    public void setFragmentText(String s){
        tvFragmentText.setText(s);
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof IFragment0){
            mListener = (IFragment0) activity;
        }
        else{
            mListener=null;
        }
    }
}


