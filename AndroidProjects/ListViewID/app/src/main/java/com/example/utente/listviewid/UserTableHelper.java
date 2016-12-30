package com.example.utente.listviewid;

import android.provider.BaseColumns;

/**
 * Created by Utente on 01/04/2016.
 */
public class UserTableHelper implements BaseColumns {
    public static final String TABLE_NAME ="users";
    public static final String NAME ="name";
    public static final String SURNAME ="surname";
    public static final String CREATE ="CREATE TABLE "+ TABLE_NAME + " ( "+ _ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+ NAME+" TEXT ,"+SURNAME+" TEXT);";
}
