package com.consoft.fragmentactivity2.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.consoft.fragmentactivity2.R;

/**
 * Created by tommaso on 21/04/16.
 */
public class MyFragment extends Fragment {
    Button mButton;
    TextView mTextView;
    IMyFragment mListener;
    Button mBtnChange;

    // per interagire dal fragment verso l'activity è necessario utilizzare un'interfaccia che farà da tramite tra i 2
    // mettendo come attributo della classe un'istanza dell'interfaccia riusciamo a tenere
    // un rifrtimento all'activity in tutte le parti del fragment
    public interface IMyFragment {
        public void setLabelActivity(String aLabel);
        public void changeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vView = inflater.inflate(R.layout.fragment_my_fragment, container, false);
        mButton = (Button) vView.findViewById(R.id.buttonFragment);
        mBtnChange = (Button) vView.findViewById(R.id.buttonChange);
        mTextView = (TextView) vView.findViewById(R.id.textViewFragment);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.setLabelActivity("premuto fragment");
            }
        });
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.changeFragment();
            }
        });
        return vView;
    }

    // per interagire dall'activity verso il fragment basta predisporre nel
    // fragment dei metodi in maniera che dall'activity attraverso l'istanza
    // dell'oggetto fragment si possono richiamare i suoi metodi
    public void setLabelFragment(String aLabel) {
        mTextView.setText(aLabel);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof IMyFragment) {
            mListener = (IMyFragment) activity;
        } else {
            mListener = null;
        }
    }
}
