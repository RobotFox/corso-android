package com.tommo.sqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tommaso on 31/03/16.
 */
public class UsersDb extends SQLiteOpenHelper/*classe per la gestione del database*/ {
    private static final String NAME = "users.db"; //nome del file SQLite che viene creato automaticamente
    private static final int VERSION = 1; //numero di versione del database

    public UsersDb(Context context) {//costruttore che ha come parametro solo il context
        super(context, NAME, null, VERSION);//utilizzo il costruttore della classe madre passandogli context,Nome del file, null (oggetto che non ci serve), versione del database
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UserTableHelper.CREATE); //eseguo l'sql per creare la tabella del database; viene eseguito solo una volta alla creazione del database
        for (int i = 0; i < 100; i++) {//inserisco dei valori nel database per provare: mettendo l'inserimento qui viene inserito una volta solo alla creazione del database e dopo la crezione della tabella
            ContentValues vValues = new ContentValues(); //contenitore per i valori da inserire
            vValues.put(UserTableHelper.NAME, "nome " + i); //inserisco nome della colonna e valore da inserire
            vValues.put(UserTableHelper.SURNAME, "cognome " + i);
            sqLiteDatabase.insert(UserTableHelper.TABLE_NAME, null, vValues);//faccio l'insert passando nome della tabella, null (oggetto che non ci serve) e valori da inserire
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//funzione che serve per l'upgrade che per ora non utilizziamo
    }
}
