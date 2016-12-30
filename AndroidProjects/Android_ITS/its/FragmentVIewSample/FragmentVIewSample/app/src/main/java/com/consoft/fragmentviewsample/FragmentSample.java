package com.consoft.fragmentviewsample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by tommaso on 14/04/16.
 */
public class FragmentSample extends Fragment/*creo una classe che estende la classe Fragment*/ {
    Button mButton;
    TextView mTextView;

    @Override/*faccio l'override del metodo onCreateView*/
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vView = inflater.inflate(R.layout.fragment_sample, container, false);//tramite l'inflater recupero la view del fragment (come facciamo nell'adapter)

        mButton = (Button) vView.findViewById(R.id.button); //mi comporto come nell'activity e faccio il binding degli elementi grafici tramite view.findViewById
        mTextView = (TextView) vView.findViewById(R.id.textView);

        mButton.setOnClickListener(new View.OnClickListener() {//stesso comportamento dell'activity
            @Override
            public void onClick(View view) {
                mTextView.setText("Mi hai premuto!");
            }
        });

        return vView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
