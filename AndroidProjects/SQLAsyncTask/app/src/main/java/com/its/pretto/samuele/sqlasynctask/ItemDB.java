package com.its.pretto.samuele.sqlasynctask;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Samuele.Pretto on 21/10/2016.
 */

public class ItemDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "items.db";
    public static final int VERSION = 1;

    public ItemDB(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ItemTableHelper.CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
