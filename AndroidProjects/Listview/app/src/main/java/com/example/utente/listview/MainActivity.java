package com.example.utente.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView= (ListView) findViewById(R.id.listView);
        ArrayList<notizia> vNotizie = new ArrayList<>();
        vNotizie.add(new notizia("Titolo1","Descrizione\n Descrizione\n Descrizione", 1));
        vNotizie.add(new notizia("Titolo2","Descrizione\n Descrizione\n Descrizione", 2));
        vNotizie.add(new notizia("Titolo3","Descrizione\n Descrizione\n Descrizione", 3));
        vNotizie.add(new notizia("Titolo4","Descrizione\n Descrizione\n Descrizione", 4));
        vNotizie.add(new notizia("Titolo5","Descrizione\n Descrizione\n Descrizione", 5));

        NotiziaAdapter vAdapter= new NotiziaAdapter(this,vNotizie);
        mListView.setAdapter(vAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
            }
        });
    }
}
