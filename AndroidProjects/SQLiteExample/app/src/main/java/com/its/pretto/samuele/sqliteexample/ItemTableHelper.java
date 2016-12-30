package com.its.pretto.samuele.sqliteexample;

import android.provider.BaseColumns;

/**
 * Created by Samuele.Pretto on 21/10/2016.
 */

public class ItemTableHelper implements BaseColumns {

    public static final String TABLE_NAME = "items";
    public static final String NAME="name";
    public static final String SURNAME = "surname";
    public static final String CREATE = "CREATE TABLE "+TABLE_NAME+" ( "+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" TEXT, "+SURNAME+" TEXT);";

}
