package com.proiect.PAO;

import java.text.ParseException;

public class Teatru extends Eveniment{
    private String trupa, regizor;

    public Teatru(String nume, int pretBilet, String gen, int durata, String data,
                  Locuri locuri, String trupa, String regizor) throws ParseException {
        super(nume, pretBilet, gen, durata, data, locuri);
        this.trupa = trupa;
        this.regizor = regizor;
    }
    public Teatru() throws ParseException {
        super();
    }

    public String getRegizor() {
        return regizor;
    }

    public void setRegizor(String regizor) {
        this.regizor = regizor;
    }

    public String getTrupa() {
        return trupa;
    }

    public void setTrupa(String trupa) {
        this.trupa = trupa;
    }
}
