package com.example.utente.listviewid;

/**
 * Created by Utente on 31/03/2016.
 */
public class User {

    private int ID;
    private String Nome;
    private String Cognome;

    public User(String cognome, int ID, String nome) {
        Cognome = cognome;
        this.ID = ID;
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }
}
