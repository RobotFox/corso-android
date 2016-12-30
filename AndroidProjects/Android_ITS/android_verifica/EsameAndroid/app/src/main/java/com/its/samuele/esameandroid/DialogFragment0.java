package com.its.samuele.esameandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Utente on 12/05/2016.
 */
public class DialogFragment0 extends DialogFragment {

    public interface IDialogFragment0{
        public void onNegativeClick();
        public void onPosativeClick();
        public void onNeutralClick();
        public void changeActivity();
    }

    IDialogFragment0 mListener;

    private String title;


    public DialogFragment0() {
    }


    public DialogFragment0(String title) {
        this.title = title;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder vBuilder = new AlertDialog.Builder(getActivity());
        title="vuoi cambiare activity?";
        vBuilder.setTitle(title);
        vBuilder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.changeActivity();
            }
        });
        vBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        vBuilder.setNeutralButton("ANNULLA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getActivity(), "Hai deciso di annullare l'operazione",
                        Toast.LENGTH_LONG).show();
            }
        });
        return vBuilder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof IDialogFragment0){
            mListener = (IDialogFragment0) activity;
        }
        else{
            mListener = null;
        }
    }
}