package com.proiect.PAO;

import java.text.ParseException;

public class Film extends Eveniment {
    private int xD;// 2d, 3d
    private String subtitrari;
    private boolean dublat;

    public Film(String nume, int pretBilet, String gen, int durata, String data,
                Locuri locuri, int xD, String subtitrari, boolean dublat) throws ParseException {
        super(nume, pretBilet, gen, durata, data, locuri);
        this.xD = xD;
        this.subtitrari = subtitrari;
        this.dublat = dublat;
    }
     public Film() throws ParseException {
        super();
        xD = 0;
        dublat= false;
     }

    public boolean isDublat() {
        return dublat;
    }

    public void setDublat(boolean dublat) {
        this.dublat = dublat;
    }

    public void setxD(int xD) {
        this.xD = xD;
    }

    public int getxD() {
        return xD;
    }

    public void setSubtitrari(String subtitrari) {
        this.subtitrari = subtitrari;
    }

    public String getSubtitrari() {
        return subtitrari;
    }
}
