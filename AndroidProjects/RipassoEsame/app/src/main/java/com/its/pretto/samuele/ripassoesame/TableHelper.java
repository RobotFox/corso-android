package com.its.pretto.samuele.ripassoesame;

import android.provider.BaseColumns;

/**
 * Created by Samuele.Pretto on 18/10/2016.
 */

public class TableHelper implements BaseColumns {

    public static final String TABLE_NAME = "items";

    public static final String DESCRIPTION = "description";

    public static final String CREATE = "CREATE TABLE "+TABLE_NAME+" ( "+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+DESCRIPTION+" TEXT);";

}
