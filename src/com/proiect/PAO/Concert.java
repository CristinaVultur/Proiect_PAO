package com.proiect.PAO;

import java.text.ParseException;

public class Concert extends Eveniment {
    private String numeArtist, tip;//live, acustic, solo, orchestra, cor, ansamblu, trupa

    public Concert(String nume, int pretBilet, String gen, int durata, String data,
                   Locuri locuri, String numeArtist) throws ParseException {
        super(nume, pretBilet, gen, durata, data, locuri);
        this.numeArtist = numeArtist;
        this.locuri = locuri;
    }
    public Concert(String value, int i, String s, int parseInt) throws ParseException {
        super();
    }

    public String getNumeArtist() {
        return numeArtist;
    }

    public void setNumeArtist(String numeArtist) {
        this.numeArtist = numeArtist;
    }
}
