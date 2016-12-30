package com.example.utente.listviewnew;

/**
 * Created by Utente on 24/03/2016.
 */
public class notizia {
    private String mTitolo;
    private String mCorpo;
    private int mId;


    public notizia(String aTitolo, String aCorpo, int aId) {
        this.mTitolo = aTitolo;
        this.mCorpo = aCorpo;
        this.mId = aId;
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

    public String getmTitolo() {
        return mTitolo;
    }

    public void setmTitolo(String mTitolo) {
        this.mTitolo = mTitolo;
    }
}
