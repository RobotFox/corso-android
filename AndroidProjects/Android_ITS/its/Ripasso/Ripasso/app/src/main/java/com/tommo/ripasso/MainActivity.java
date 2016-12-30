package com.tommo.ripasso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String COUNTER = "COUNTER";
    Button mPlus, mMinus;//mappo 1 a 1 gli oggetti grafici e gli oggetti che mi servono nel codice
    TextView mDisplay;//mappo 1 a 1 gli oggetti grafici e gli oggetti che mi servono nel codice
    int mCounter;
    Button mChangeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//associa l'activity MainActivity a layout activity_main.xml
        mDisplay = (TextView) findViewById(R.id.counterDisplay);//associo all'oggetto mDisplay (di tipo TextVIew) l'elemento grafico con id counterDisplay
        mPlus = (Button) findViewById(R.id.buttonPlus);//associo all'oggetto mPlus (di tipo Button) l'elemento grafico con id buttonPlus
        mMinus = (Button) findViewById(R.id.buttonMinus);//associo all'oggetto mMinus (di tipo Button) l'elemento grafico con id buttonMinus
        mChangeActivity = (Button) findViewById(R.id.buttonChange);//associo all'oggetto mChangeActivity (di tipo Button) l'elemento grafico con id buttonChange
        if (savedInstanceState != null) {//controllo che non sia nullo perchè al primo avvio dell'app non ci sarà nulla
            mCounter = savedInstanceState.getInt(COUNTER);//tiro fuoti dal bundle il valore che mi interessa
        } else {
            mCounter = 0;//inizializzo mCounter a 0
            //nel caso il bundle sia nullo e quindi non ha nessun valore salvato
        }

        mDisplay.setText(Integer.toString(mCounter));//stampo il mio contatore (mCounter) sulla mia TextView (mDisplay)
        mPlus.setOnClickListener(new View.OnClickListener() {//setto l'OnClickListener tramite un'implementazione anonima
            @Override
            public void onClick(View view) {//faccio l'override della funzione onClick
                mCounter++;//incremento mCounter di 1
                mDisplay.setText(Integer.toString(mCounter));//stampo mCounter nella mia TextView (mDisplay)
            }
        });
        mMinus.setOnClickListener(new View.OnClickListener() {//setto l'OnClickListener tramite un'implementazione anonima
            @Override
            public void onClick(View view) {//faccio l'override della funzione onClick
                mCounter--;//decremento mCounter di 1
                mDisplay.setText(Integer.toString(mCounter));//stampo mCounter nella mia TextView (mDisplay)
            }
        });
        mChangeActivity.setOnClickListener(new View.OnClickListener() {//setto l'OnClickListener tramite un'implementazione anonima
            @Override
            public void onClick(View view) {//faccio l'override della funzione onClick
                Intent vIntent = new Intent(MainActivity.this, MainActivity2.class);//creo un nuovo intent dandogli come parametri ActivityPartenza.this, ActivityArrivo.class
                Bundle vBundle = new Bundle();//creo un nuovo bundle dove mettere i valori da usare nella nuova activity
                vBundle.putInt(COUNTER, mCounter);//metto nel bundle un valore di tipo int
                vIntent.putExtras(vBundle);//aggiungo all'intent il bundle in maniera che possa essere utilizzato nella nuova activity
                startActivity(vIntent);//faccio lo startActivity in maniera da eseguire il passaggio dichiarato nell'intent
            }
        });
    }

    //per creare in automatico l'override premere tasto destro->Generate->Override methods->Selezionare metodo desiderato
    @Override
    protected void onSaveInstanceState(Bundle outState) {//faccio l'override del metodo onSaveInstanceState (in modo da salvarmi i valori quando giro il cellulare)
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER, mCounter);//andiamo a inserire nel bundle il valore da salvare
        //il bundle è un oggetto di tipo chiave valore

    }
}
