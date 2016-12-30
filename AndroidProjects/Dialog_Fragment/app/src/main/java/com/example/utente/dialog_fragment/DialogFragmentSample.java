package com.example.utente.dialog_fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Utente on 28/04/2016.
 */
public class DialogFragmentSample extends DialogFragment {
    public interface ICustomDialogFragment{
        public void onNegativeClick();
        public void onPosativeClick();
        public void onNeutralClick();
    }

    ICustomDialogFragment mListener;

    private String title;
    private String message;


    public DialogFragmentSample() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder vBuilder = new AlertDialog.Builder(getActivity());
        message = getArguments().getString("MES");
        title = getArguments().getString("TIT");
        vBuilder.setTitle(title);
        vBuilder.setMessage(message);
        vBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity s = new MainActivity();
                s.setText("Ok");
            }
        });
        vBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onPosativeClick();
            }
        });

        vBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onNegativeClick();

            }
        });
        vBuilder.setNeutralButton("X", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onNeutralClick();
            }
        });
        return vBuilder.create();

    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (activity instanceof ICustomDialogFragment){
            mListener = (ICustomDialogFragment) activity;
        }
        else {
            mListener=null;
        }
    }
}
