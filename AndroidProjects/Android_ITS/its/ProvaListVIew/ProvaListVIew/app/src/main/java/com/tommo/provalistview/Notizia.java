package com.tommo.provalistview;

/**
 * Created by tommaso on 17/03/16.
 */
public class Notizia {
    private String mTitolo;
    private String mCorpo;
    private int mId;

    public Notizia(String aTitolo, String aCorpo, int aId) {
        this.mTitolo = aTitolo;
        this.mCorpo = aCorpo;
        this.mId = aId;
    }

    public String getmTitolo() {
        return mTitolo;
    }

    public void setmTitolo(String mTitolo) {
        this.mTitolo = mTitolo;
    }

    public String getmCorpo() {
        return mCorpo;
    }

    public void setmCorpo(String mCorpo) {
        this.mCorpo = mCorpo;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }
}
