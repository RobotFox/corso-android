package com.its.pretto.samuele.ripassoesame;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Samuele.Pretto on 18/10/2016.
 */

public class ItemDB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "database.db";
    public static final int VERSION = 1;


    public ItemDB(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TableHelper.CREATE);
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableHelper.DESCRIPTION,"Descrizione1");
        db.insert(TableHelper.TABLE_NAME,null,contentValues);

        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(TableHelper.DESCRIPTION,"Descrizione2");
        db.insert(TableHelper.TABLE_NAME,null,contentValues2);

        ContentValues contentValues3 = new ContentValues();
        contentValues3.put(TableHelper.DESCRIPTION,"Descrizione3");
        db.insert(TableHelper.TABLE_NAME,null,contentValues3);

        ContentValues contentValues4 = new ContentValues();
        contentValues4.put(TableHelper.DESCRIPTION,"Descrizione4");
        db.insert(TableHelper.TABLE_NAME,null,contentValues4);

        ContentValues contentValues5 = new ContentValues();
        contentValues5.put(TableHelper.DESCRIPTION,"Descrizione5");
        db.insert(TableHelper.TABLE_NAME,null,contentValues5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
