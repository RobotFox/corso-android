package com.example.utente.fragmentviewsample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Utente on 14/04/2016.
 */
public class FragmentSample extends Fragment {

    Button mButton;
    TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vView = inflater.inflate(R.layout.fragment_sample,container,false);

        mButton = (Button) vView.findViewById(R.id.button);
        mTextView = (TextView) vView.findViewById(R.id.textView);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("Mi hai premuto!");
            }
        });

        return vView;
    }
}
