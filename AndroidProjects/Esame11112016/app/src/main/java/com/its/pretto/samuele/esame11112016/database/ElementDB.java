package com.its.pretto.samuele.esame11112016.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Samuele.Pretto on 11/11/2016.
 */

public class ElementDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "elements.db";
    public static final int VERSION = 1;

    public ElementDB(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ElementTableHelper.CREATE);
        ContentValues values;
        String[] descriptions = {"Lorem", "Ipsum","Dolor","Sit","Amet"};
        for (int i=0; i <descriptions.length; i++){
            values = new ContentValues();
            values.put(ElementTableHelper.DESCRIPTION,descriptions[i]);
            db.insert(ElementTableHelper.TABLE_NAME,null,values);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
