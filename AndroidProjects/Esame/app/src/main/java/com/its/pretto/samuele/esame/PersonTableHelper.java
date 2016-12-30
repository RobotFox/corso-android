package com.its.pretto.samuele.esame;

import android.provider.BaseColumns;

/**
 * Created by Samuele.Pretto on 25/10/2016.
 */

public class PersonTableHelper implements BaseColumns {

    public static final String TABLE_NAME = "people";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String CREATE = "CREATE TABLE "+TABLE_NAME+
            " ( "+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NAME+" TEXT, "+
            SURNAME+" TEXT);";

}
