package com.tommo.sqlite.model;

/**
 * Created by tommaso on 01/04/16.
 */
public class User {
    private int mId;
    private String mName;
    private String mSurname;

    public User(int mId, String mName, String mSurname) {
        this.mId = mId;
        this.mName = mName;
        this.mSurname = mSurname;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSurname() {
        return mSurname;
    }

    public void setmSurname(String mSurname) {
        this.mSurname = mSurname;
    }
}
