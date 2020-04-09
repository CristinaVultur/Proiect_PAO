package com.proiect.PAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class Locuri {
    private ArrayList<Loc> locuri;
    private TreeMap<String,Integer> prop;

    public Locuri(ArrayList<Loc> locuri, int[] p){
        this.locuri = new ArrayList<>();
        this.locuri.addAll(locuri);
        prop = new TreeMap<>();
        String []s={"nrTotal", "nrDisponibil","nrTotalNormal","normal","nrTotalLoja", "loja", "nrTotalVIP", "VIP"};
        for(int i=0;i<8;i++){
            prop.put(s[i],p[i]);
        }
    }
    public Locuri(int[] p){
        this.locuri = new ArrayList<>();
        prop = new TreeMap<>();
        String []s={"nrTotal", "nrDisponibil","nrTotalNormal","normal","nrTotalLoja", "loja", "nrTotalVIP", "VIP"};
        for(int i=0;i<8;i++){
            prop.put(s[i],p[i]);
        }
    }
    public Locuri(){
        this(null, new int[]{0, 0, 0, 0, 0, 0, 0, 0});
    }

    public Locuri(Locuri L){ //copy constructor
        this.locuri = new ArrayList<Loc>();
        this.prop = new TreeMap<String, Integer>();
        this.locuri.addAll(L.locuri);
        prop.putAll(L.prop);
    }
    public ArrayList<Loc> getLocuri(){
        return this.locuri;
    }
    public Loc getLoc(int i){
        return this.locuri.get(i);
    }
    public void setLocuri(Locuri L){
        this.locuri = L.locuri;
        this.prop = L.prop;
    }
    public void setProp(TreeMap<String,Integer> prop){
        this.prop = prop;
    }
    public void setPropManually(int []p){
        int i=0;
        for(String s:this.prop.keySet()){
            this.prop.put(s, p[i]);
            i++;
        }
    }
    public void setDoarLocuri(ArrayList<Loc> locuri){
        this.locuri = locuri;
    }

    public void setLoc(Loc l, int i){
        this.locuri.set(i, l);
    }

    public TreeMap<String,Integer> getProp(){
        return this.prop;
    }

    public void setOneProp(String prop, int i){
        this.prop.put(prop,i);
    }


    public int getOneProp(String prop){
        return this.prop.get(prop);
    }

    public void DecreaseOneProp(String prop){

        int nr = this.prop.get(prop);
        this.prop.put(prop, nr-1); //cand se rezerva un bilet

        this.prop.put("nrDisponibil", this.prop.get("nrDisponibil")-1);//scadem din nr total
    }

    public void IncreaseOneProp(String prop){ //cand se anuleaza rezervarea
        this.prop.put(prop, this.prop.get(prop)+1);
        this.prop.put("nrDisponibil", this.prop.get("nrDisponibil")+1);
        //this.locuri.get(i).setDisponibil(true);
    }

    //pt rezervarea unui bilet
    public Loc cautareDupaCod(int cod){
        for(Loc l:this.locuri){
            if(l.getCod()==cod) return l;
        }
        System.out.println("Locul nu a fost gasit");
        final Loc o = null;
        return o;
    }
    public void creareLocuri(){

        int c=1;
        for(int i= 1; i<=this.getOneProp("nrTotalNormal");i++)
            this.locuri.add(new Loc("normal",c++));
        for(int i = 1; i<=this.getOneProp("nrTotalLoja");i++)
            this.locuri.add(new Loc("loja",c++));
        for(int i = 1; i<=this.getOneProp("nrTotalVIP");i++)
            this.locuri.add(new Loc("VIP",c++));
    }
}
