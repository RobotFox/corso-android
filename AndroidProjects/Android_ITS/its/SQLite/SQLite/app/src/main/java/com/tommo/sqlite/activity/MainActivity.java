package com.tommo.sqlite.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.tommo.sqlite.R;
import com.tommo.sqlite.adapter.UserAdapter;
import com.tommo.sqlite.data.UserTableHelper;
import com.tommo.sqlite.data.UsersDb;
import com.tommo.sqlite.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);

        /*SQLiteDatabase vDataWritable = new UsersDb(MainActivity.this).getWritableDatabase();
        for (int i = 0; i < 200; i++) {
            ContentValues vValues = new ContentValues();
            vValues.put(UserTableHelper._ID, i);
            vValues.put(UserTableHelper.NAME, "name" + i);
            vValues.put(UserTableHelper.SURNAME, "surname" + i);
            //vDataWritable.insert(UserTableHelper.TABLE_NAME, null, vValues);
            vDataWritable.insertOrThrow(UserTableHelper.TABLE_NAME, null, vValues);
        }
        vDataWritable.close();*/


        SQLiteDatabase vData = new UsersDb(MainActivity.this).getReadableDatabase();//tramite il costruttore fatto da noi e il metodo getReadableDatabase() mi recupoero un database in lettura


        Cursor vCursor = vData.query(UserTableHelper.TABLE_NAME,
                new String[]{UserTableHelper._ID, UserTableHelper.NAME, UserTableHelper.SURNAME},
                null, null, null, null, null);//faccio una query sul database utilizzando il metodo query per capire i parametri vedi documentazione : http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html#query(java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String)
//la query mi restituisce un oggetto di tipo cursor che contiene tutte le righe del database e serve per scorrerle

        int vNameIndex = vCursor.getColumnIndex(UserTableHelper.NAME); //dal cursor mi tiro fuori tutti gli indici delle colonne che ci serviranno dopo
        int vSurnameIndex = vCursor.getColumnIndex(UserTableHelper.SURNAME);
        int vIdIndex = vCursor.getColumnIndex(UserTableHelper._ID);


        ArrayList<User> vUsers = new ArrayList<>();//creo un arraylist per mettere tutti i dati che poi recupero dal database


        while (vCursor.moveToNext()) {//controllo sempre che il cursor abbia una riga in maniera da non andare in outOfBound

            vUsers.add(new User(
                    vCursor.getInt(vIdIndex),//estraggo i dati dal cursor grazie agli indici delle colonne
                    vCursor.getString(vNameIndex),
                    vCursor.getString(vSurnameIndex)));//creo un'oggetto user che aggiungo all'arraylist
        }

        vCursor.close();
        vData.close();

        UserAdapter vAdapter = new UserAdapter(MainActivity.this, vUsers);
        mListView.setAdapter(vAdapter);
    }
}
