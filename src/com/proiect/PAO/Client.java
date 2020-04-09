package com.proiect.PAO;

import java.util.Comparator;
import java.util.TreeMap;

public class Client {
    private String nume;
    private int varsta;
    private String mail;
    TreeMap<Eveniment,Loc> locuriRezervate; //map pentru spectacolele la care a facut rezervare si locurile sale

    //ordonam evenimentele in functie de data

    class cmp implements Comparator<Eveniment>{// vreau sa tin spectacolele ordinate in functie de data

        @Override
        public int compare(Eveniment eveniment, Eveniment t1) {
            return eveniment.getData().compareTo(t1.getData());
        }
    }

    public Client( String nume, int varsta, String mail, TreeMap<Eveniment,Loc> locuriRezervate){
        this.nume = nume;
        this.varsta = varsta;
        this.mail = mail;
        this.locuriRezervate = new TreeMap(new cmp());
        this.locuriRezervate.putAll(locuriRezervate);
    }

    public Client( String nume, int varsta, String mail){// constructor fara locuri rezervate pentru ca vr sa le adaug dupa
        this.nume = nume;
        this.varsta = varsta;
        this.mail = mail;
        this.locuriRezervate = new TreeMap(new cmp());
    }

    public Client(){
        this(null,0,null);
    }

    // pt rezervare si anularea rezervarii

    public void setUnLoc(Eveniment e, Loc l){
        locuriRezervate.put(e,l);
    }
    public void stergeUnLoc(Eveniment e){
        this.locuriRezervate.remove(e);
    }

    //setters and getters

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public TreeMap<Eveniment, Loc> getLocuriRezervate() {
        return locuriRezervate;
    }

    public void setLocuriRezervate(TreeMap<Eveniment, Loc> locuriRezervate) {
        this.locuriRezervate = locuriRezervate;
    }
}
