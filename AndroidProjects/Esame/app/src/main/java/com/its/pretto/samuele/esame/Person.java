package com.its.pretto.samuele.esame;

/**
 * Created by Samuele.Pretto on 25/10/2016.
 */

public class Person {

    private int _id;
    private String name;
    private String surname;

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
