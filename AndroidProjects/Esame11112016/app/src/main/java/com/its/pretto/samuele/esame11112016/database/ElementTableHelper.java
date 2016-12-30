package com.its.pretto.samuele.esame11112016.database;

import android.provider.BaseColumns;

/**
 * Created by Samuele.Pretto on 11/11/2016.
 */

public class ElementTableHelper implements BaseColumns {

    public static final String TABLE_NAME ="elements";
    public static final String DESCRIPTION = "description";
    public static final String CREATE = "CREATE TABLE "+TABLE_NAME+
            "( "+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            DESCRIPTION+" TEXT);";
}
