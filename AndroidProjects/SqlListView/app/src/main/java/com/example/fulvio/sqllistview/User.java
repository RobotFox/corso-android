package com.example.fulvio.sqllistview;

/**
 * Created by Fulvio on 01/04/2016.
 */
public class User {
    protected int mId;
    protected String mName;
    protected String mSurname;

    public User(int aId, String aName, String aSurname) {
        mId = aId;
        mName = aName;
        mSurname = aSurname;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int aId) {
        mId = aId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String aName) {
        mName = aName;
    }

    public String getmSurname() {
        return mSurname;
    }

    public void setmSurname(String aSurname) {
        mSurname = aSurname;
    }
}
