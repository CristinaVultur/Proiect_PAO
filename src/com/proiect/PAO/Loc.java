package com.proiect.PAO;

public class Loc {
    private String tip; //normal, loja, VIP
    private int cod;
    private double pretLoc;
    private boolean disponibil;

    public Loc(String tip, int cod){
        this.tip = tip;
        this.cod = cod;
        this.disponibil = true;
        if(tip.equals("normal")) //pretLoc va fi inmultit cu pret eveniment
            pretLoc=1;
        else {
            if (tip.equals("loja"))
                pretLoc = 1.5;
            else if(tip.equals("VIP"))  pretLoc = 2;
            else pretLoc = 0;
        }

    }
    public Loc(){
        this("Necunoscut", 0);
    }
    //constructor de copiere
    public Loc(Loc l){
        this.tip = l.tip;
        this.cod = l.cod;
        this.disponibil = l.disponibil;
        this.pretLoc = l.pretLoc;
    }
    public String getTip(){
        return this.tip;
    }
    public void setTip(String s){ this.tip = s;}

    public int getCod(){
        return this.cod;
    }
    public void setCod(int cod){ this.cod = cod;}

    public double getPretLoc(){
        return this.pretLoc;
    }

    public boolean getDisponibil(){
        return this.disponibil;
    }
    public void setDisponibil(boolean mod){
        this.disponibil = mod;
    }



}
