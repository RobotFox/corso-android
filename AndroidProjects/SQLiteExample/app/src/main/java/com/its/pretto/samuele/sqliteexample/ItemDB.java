package com.its.pretto.samuele.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Samuele.Pretto on 21/10/2016.
 */

public class ItemDB extends SQLiteOpenHelper {

    public static final int VERSION=1;
    public static final String DB_NAME = "items.db";

    public ItemDB(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ItemTableHelper.CREATE);
        ContentValues values;
        for (int i=0; i<5;i++){
            values = new ContentValues();
            values.put(ItemTableHelper.NAME,"name "+i);
            values.put(ItemTableHelper.SURNAME,"surname "+i);
            db.insert(ItemTableHelper.TABLE_NAME,null,values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
