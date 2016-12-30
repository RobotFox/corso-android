package com.its.pretto.samuele.sqlitetwotables;

import android.provider.BaseColumns;

/**
 * Created by Samuele.Pretto on 08/11/2016.
 */

public class Table2Helper implements BaseColumns {

    public static final String TABLE_NAME = "tabella2";
    public static final String DESCRIPTION ="descrizione";
    public static final String CREATE = "CREATE TABLE "+TABLE_NAME+ " ( "
            +_ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "
            +DESCRIPTION+" TEXT );";
}
