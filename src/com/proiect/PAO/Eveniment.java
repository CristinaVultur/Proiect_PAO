package com.proiect.PAO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Eveniment{
    protected String nume;
    protected int pretBilet;
    protected String gen;
    protected int durata;
    protected Date data;
    protected Locuri locuri;

    public Eveniment(String nume, int pretBilet, String gen,
                     int durata, String data, Locuri locuri) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            this.nume = nume;
            this.pretBilet = pretBilet;
            this.gen= gen;
            this.durata = durata;
            this.data= format.parse ( data ); ;
            this.locuri = new Locuri(locuri);

    }
    public Eveniment() throws ParseException {
        this(null, 0, null, 0, null, null);

    }

    public void setNume(String nume){  this.nume = nume;  }
    public String getNume(){   return this.nume;  }

    public void setPretBilet(int pret){  this.pretBilet=pret;   }
    public int getPretBilet(){  return this.pretBilet;  }

    public void setGen(String gen) { this.gen = gen;  }
    public String getGen(){ return this.gen;  }

    public void setDurata(int durata){ this.durata = durata; }
    public int getDurata(){  return this.durata; }

    public Locuri getLocuriEveniment() { return locuri; }

    public void setLocuri(Locuri locuri) { this.locuri = locuri; }

    public Date getData() { return data; }

    public void setData(String data) throws ParseException {
        this.data= DateFormat.getDateInstance(DateFormat.DEFAULT).parse(data);
    }

    public void afisare(){
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        System.out.print("Nume:"+nume+" in data de:"+ dateFormat.format(data)+", pret bilet:"+pretBilet+", genul:"+gen+",durata: "+durata+"h");
    }
}
