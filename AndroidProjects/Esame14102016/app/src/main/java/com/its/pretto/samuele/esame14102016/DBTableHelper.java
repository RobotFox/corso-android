package com.its.pretto.samuele.esame14102016;

import android.provider.BaseColumns;

/**
 * Created by Samuele.Pretto on 14/10/2016.
 */

public class DBTableHelper implements BaseColumns {

    public static final String TABLE_NAME = "list";
    public static final String DESCRIPTION = "description";

    public static final String CREATE = "CREATE TABLE "+TABLE_NAME+" ( "+_ID+" INTEGER PRIMARY KEY, "+DESCRIPTION+" TEXT);";

}
