package com.its.pretto.samuele.esame;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Samuele.Pretto on 25/10/2016.
 */

public class PersonDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "people.db";
    public static final int VERSION = 1;

    public PersonDB(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(PersonTableHelper.CREATE);
        ContentValues values;
        String[] names = {"Braccobaldo","Astolfo","Ermenegildo","Rambazzo","Ernesto"};
        String[] surnames = {"Grigiobaldi","Abatangelo","Naitana","Fabbrica","Random"};
        for (int i =0; i<5;i++){
            values = new ContentValues();
            values.put(PersonTableHelper.NAME,names[i]);
            values.put(PersonTableHelper.SURNAME,surnames[i]);
            db.insert(PersonTableHelper.TABLE_NAME,null,values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
