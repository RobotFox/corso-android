package com.example.fulvio.sqllistview;

import android.provider.BaseColumns;

/**
 * Created by Fulvio on 01/04/2016.
 */
// this class is used to record all the names of the table and of the columns
public class UserTable implements BaseColumns { // BaseColumns is an interface that has the members _ID and _COUNT
    public static final String TABLE_NAME = "users"; // table's name
    public static final String NAME = "name"; // column's name
    public static final String SURNAME = "surname";
    public static final String CREATE = "CREATE TABLE " + TABLE_NAME + " ( " + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + SURNAME + " TEXT);"; // string to make the database
}
