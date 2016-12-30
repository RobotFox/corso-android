package com.its.pretto.samuele.sqlasynctask;

import android.provider.BaseColumns;

/**
 * Created by Samuele.Pretto on 21/10/2016.
 */

public class ItemTableHelper implements BaseColumns {

    public static final String TABLE_NAME = "items";
    public static final String DATA = "data";
    public static final String NUM = "num";

    public static final String CREATE = "CREATE TABLE "+TABLE_NAME+" ( "+_ID+" INTEGER PRIMARY KEY, "+DATA+" TEXT, "+NUM+" INTEGER);";

}
