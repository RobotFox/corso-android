package com.example.utente.fragmentactivity.Fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.utente.fragmentactivity.R;

/**
 * Created by Utente on 21/04/2016.
 */
public class MyFragment extends Fragment {

    Button mButton;
    TextView mTextView;
    IMyFragment mListener;

    public interface IMyFragment{
public void setLabelActivity (String label);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vView = inflater.inflate(R.layout.fragment_my_fragment,container,false);

        mButton = (Button) vView.findViewById(R.id.buttonFragment);
        mTextView = (TextView) vView.findViewById(R.id.textViewFragment);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.setLabelActivity("premuto fragment");
            }
        });
        return vView;
    }

    public void setLabelFragment(String sLabel){
        mTextView.setText(sLabel);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof IMyFragment){
            mListener = (IMyFragment) activity;
        }
        else {
            mListener=null;
        }
    }
}
