package com.tommo.provalistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        ArrayList<Notizia> vNotizie = new ArrayList<>();
        vNotizie.add(new Notizia("Titolo1"
                , "Descrizione Descrizione " +
                "\nDescrizione Descrizione Descrizione"
                , 1));
        vNotizie.add(new Notizia("Titolo2"
                , "Descrizione Descrizione " +
                "\nDescrizione Descrizione Descrizione"
                , 2));
        vNotizie.add(new Notizia("Titolo3"
                , "Descrizione Descrizione " +
                "\nDescrizione Descrizione Descrizione"
                , 3));
        vNotizie.add(new Notizia("Titolo4"
                , "Descrizione Descrizione " +
                "\nDescrizione Descrizione Descrizione"
                , 4));
        vNotizie.add(new Notizia("Titolo5"
                , "Descrizione Descrizione " +
                "\nDescrizione Descrizione Descrizione"
                , 5));
        /*creiamo un array di oggetti di tipo notizia e lo andiamo a popolare
        questo array dopo lo utilizzaremo per l'adapter.
         */

        NotiziaAdapter vAdapter = new NotiziaAdapter(this, vNotizie);//creo un'istanza di NotiziaAdapter usando il costruttore definito da noi
        mListView.setAdapter(vAdapter);//associo alla ListView l'adapter che ho appena creato

    }
}
