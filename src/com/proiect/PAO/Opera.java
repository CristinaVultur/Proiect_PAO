package com.proiect.PAO;

import java.text.ParseException;

public class Opera extends Eveniment{
    private String trupa, orchestra, dirijor;

    public Opera(String nume, int pretBilet, String gen, int durata,
                 String data, Locuri locuri, String trupa, String orchestra , String dirijor) throws ParseException {
        super(nume, pretBilet, gen, durata, data, locuri);
        this.trupa = trupa;
        this.orchestra = orchestra;
        this.dirijor = dirijor;
    }

    public Opera() throws ParseException {
        super();
    }

    public void setTrupa(String trupa) {
        this.trupa = trupa;
    }

    public String getTrupa() {
        return trupa;
    }

    public String getDirijor() {
        return dirijor;
    }

    public void setDirijor(String dirijor) {
        this.dirijor = dirijor;
    }

    public String getOrchestra() {
        return orchestra;
    }

    public void setOrchestra(String orchestra) {
        this.orchestra = orchestra;
    }
}
