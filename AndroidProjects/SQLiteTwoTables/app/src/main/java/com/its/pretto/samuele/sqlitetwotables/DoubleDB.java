package com.its.pretto.samuele.sqlitetwotables;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Samuele.Pretto on 08/11/2016.
 */

public class DoubleDB extends SQLiteOpenHelper {

    public static final String DB_NAME="doubledb.db";
    public static final int VERSION =1;

    public DoubleDB(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Table2Helper.CREATE);
        db.execSQL(Table1Helper.CREATE);
        for (int i=0;i<5;i++){
            ContentValues values = new ContentValues();
            values.put(Table2Helper.DESCRIPTION,"descrizione"+i);
            db.insert(Table2Helper.TABLE_NAME,null,values);
        }

        Cursor vCursor = db.query(Table2Helper.TABLE_NAME,new String[]{Table2Helper._ID,Table2Helper.DESCRIPTION},null,null,null,null,null);
        while (vCursor.moveToNext()){
            ContentValues values = new ContentValues();
            values.put(Table1Helper.ID_DESCRIZIONE,vCursor.getInt(vCursor.getColumnIndex(Table2Helper._ID)));
            values.put(Table1Helper.NAME,"nome"+vCursor.getInt(vCursor.getColumnIndex(Table2Helper._ID)));
            values.put(Table1Helper.SURNAME,"cognome"+vCursor.getInt(vCursor.getColumnIndex(Table2Helper._ID)));
            db.insert(Table1Helper.TABLE_NAME,null,values);
        }
        vCursor.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
