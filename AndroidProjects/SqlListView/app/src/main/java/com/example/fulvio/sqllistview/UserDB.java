package com.example.fulvio.sqllistview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Fulvio on 01/04/2016.
 */
public class UserDB extends SQLiteOpenHelper { // class to manage the database
    private static final String NAME = "users.db"; // name of the SQLite file automatically created
    private static final int VERSION = 1; // database version number

    public UserDB(Context context) {
        super(context, NAME, null, VERSION); // use the constructor of class mather using context, file's name, null (useless object), databbase version
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserTable.CREATE); // execute sql to create the database's table; executed only once at database's creation
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
