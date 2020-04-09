package com.proiect.PAO;

import java.text.ParseException;

public class Concert extends Eveniment {
    private String numeArtist, tip;//live, acustic, solo, orchestra, cor, ansamblu, trupa

    public Concert(String nume, int pretBilet, String gen, int durata, String data,
                   Locuri locuri, String numeArtist, String tip) throws ParseException {
        super(nume, pretBilet, gen, durata, data, locuri);
        this.numeArtist = numeArtist;
        this.locuri = locuri;
    }
    public Concert() throws ParseException {
        super();
    }

    public String getNumeArtist() {
        return numeArtist;
    }

    public void setNumeArtist(String numeArtist) {
        this.numeArtist = numeArtist;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
