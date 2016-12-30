package com.its.pretto.samuele.sqliteexample;

/**
 * Created by Samuele.Pretto on 21/10/2016.
 */

public class Item {

    private String name;
    private String surname;
    private int _id;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
