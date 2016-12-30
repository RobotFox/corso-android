package com.tommo.sqlite.data;

import android.provider.BaseColumns;

/**
 * Created by tommaso on 31/03/16.
 */
public class UserTableHelper implements BaseColumns/*BaseColumns è una interfaccia che contine i membri _ID e _COUNT*/ {
    //questa classe serve come classe di appoggio per memorizzare tutti i nomi delle colonne e della tabella creata in SQLite
    public static final String TABLE_NAME = "users";//nome della tabella
    public static final String NAME = "name"; //nome colonna della tabella
    public static final String SURNAME = "surname"; //nome colonna della tabella
    public static final String CREATE = "CREATE TABLE " + TABLE_NAME + " ( "
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT ," + SURNAME + " TEXT);";//Stringa di creazione del database semplice sql
}
