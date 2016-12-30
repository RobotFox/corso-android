package com.its.pretto.samuele.sqlitetwotables;

import android.provider.BaseColumns;

/**
 * Created by Samuele.Pretto on 08/11/2016.
 */

public class Table1Helper implements BaseColumns {

    public static final String TABLE_NAME = "tabella1";
    public static final String NAME ="nome";
    public static final String SURNAME = "cognome";
    public static final String ID_DESCRIZIONE= "id_descrizione";
    public static final String CREATE =
            "CREATE TABLE " +TABLE_NAME+ " ( "
            +_ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "
            +NAME+" TEXT , "
            +SURNAME+" TEXT , "
            +ID_DESCRIZIONE+" INTEGER, FOREIGN KEY("+ID_DESCRIZIONE+") REFERENCES "+Table2Helper.TABLE_NAME+"("+Table2Helper._ID+") );";
}
