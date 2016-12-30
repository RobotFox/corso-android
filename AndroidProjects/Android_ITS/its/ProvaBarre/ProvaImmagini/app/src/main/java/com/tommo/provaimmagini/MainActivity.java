package com.tommo.provaimmagini;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Esercisio di esempio per l'utilizzo di seekBar e ratingBar
    SeekBar mSeekBar;
    RatingBar mRtingBar;
    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRtingBar = (RatingBar) findViewById(R.id.ratingBar);
        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mText = (TextView) findViewById(R.id.textView);
        mSeekBar.setMax(10);//qui possiamo settare il valore massimo a cui può arrivare la seekBar
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //attraverso questa implementazione anonima di classe noi possimao monitorare tutti i cambiamenti della seekbar e vedere il valore associato
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d("SEB", i + "");
                mText.setText(i + "");
                //la i sta ad indicare il valore della seekbar
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//la ratingbar lavora in maniera simile rispetto alla seekbar però puo avere anche dei valori di tipo float (la seekbar può avere solo int)
        mRtingBar.setNumStars(7);//possiamo settare il numero di stelle da visualizzare
        mRtingBar.setStepSize((float) 0.5);//possiamo settare lo step con cui vogliamo votare (per esempio possiamo assegnare anche la mezza stella

        mRtingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            //implementazione anonima di classe che ci permette di monitorare i cambiamenti sulla ratingbar
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                mText.setText(v + "");
                //il valore v è il voto sulla seekbar che è dettato anche dallo stepsize assegnato
            }
        });
    }
}
