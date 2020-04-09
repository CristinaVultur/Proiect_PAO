package com.proiect.PAO;




import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public final class ClientService {

    private ClientService(){}

    public static void rezervareBilet(Eveniment e, int cod , String tip, Client c){ //rezerva un bilet la un evenimen

        c.setUnLoc(e,e.getLocuriEveniment().cautareDupaCod(cod));//adaug locul si evenimentul in treemap-ul clientului cu locuri rezervate
        e.getLocuriEveniment().DecreaseOneProp(tip);;//scad nr de locuri disponibile si nr de locuri disponibile de acel tip
        e.getLocuriEveniment().cautareDupaCod(cod).setDisponibil(false);//setez disponibilitatea biletului ca fals
        System.out.println("Bilet rezervat!");
    }

    public static void cautareLocuri(Eveniment e, String tip){ //cauta un loc disponibil dupa tipul sau : loja, normal ,vip
        boolean gasit = false;
        for(Loc loc: e.getLocuriEveniment().getLocuri())
            if (loc.getTip().equals(tip) && loc.getDisponibil()) {
                System.out.print(tip + " " + loc.getCod()+" pret: "+(e.getPretBilet()*loc.getPretLoc()));
                gasit = true;
                System.out.print("\n");
            }

        if(!gasit) System.out.println("Nu mai exista locuri disponibile");

    }

    public static void anuleazaRezervarea(Eveniment e, Client c){ //anularea rezervarii

        Loc l = new Loc(c.getLocuriRezervate().get(e));
        e.getLocuriEveniment().IncreaseOneProp(l.getTip());// cresc nr de locuri disponiblile
        e.getLocuriEveniment().cautareDupaCod(l.getCod()).setDisponibil(true); //setez disponiblilitatea ca fiind avdevarata
        c.stergeUnLoc(e);
        System.out.println("Anulat cu succes");
    }

    public static void afisareLocuriRezervate(Client c){ //afisare locuri pe care le-a rezervat deja

        for(Eveniment e:c.getLocuriRezervate().keySet()){
            e.afisare();
            System.out.print(": loc rezervat: "+c.getLocuriRezervate().get(e).getTip()+" "+c.getLocuriRezervate().get(e).getCod()+"\n");

        }
        if(c.getLocuriRezervate().isEmpty()) System.out.println("Nu exista rezervari facute.");
    }

    public static void cautareEvenimenteInData(ArrayList<Eveniment> events,String data) throws ParseException { //cauta evenimente intr-o anumita data

        Date caut = DateFormat.getDateInstance(DateFormat.DEFAULT).parse(data);
        boolean gasit = false;
        for(Eveniment E:events){
            if(E.getData().compareTo(caut)<0)
                continue;
            else if(E.getData().compareTo(caut)==0) {
                E.afisare();
                System.out.print("\n");
                gasit = true;
            }
            else break;
        }
        if(!gasit) System.out.println("Nu exista spectacole in aceasta data");
    }

    public static void cautareEvenimenteDupaGen(ArrayList<Eveniment> events, String gen){ //cauta dupa un anum gen

        boolean gasit = false;
        for(Eveniment E:events) {
            if(E.getGen().equals(gen)){
                gasit = true;
                E.afisare();
                System.out.print("\n");
            }
        }
        if(!gasit) System.out.println("Nu exista spectacole de acest gen");
    }

    public static void AfiseazaToateEvenimenteleDisponibile(ArrayList<Eveniment> events){

        boolean gasit = false;
        for(Eveniment E:events) {
            if(E.getLocuriEveniment().getOneProp("nrDisponibil")>0){ //daca exista locuri disponibile la evenim il afisez
                gasit = true;
                E.afisare();
                System.out.print("\n");
            }
        }
        if(!gasit) System.out.println("Nu mai exista spectacole cu locuri disponibile");
    }

    public static void schimbaLocul(Eveniment e, int cod , String tip, Client c){

            ClientService.anuleazaRezervarea(e,c);
            ClientService.rezervareBilet(e,cod,tip,c);
            System.out.println("Schimbare reusita");
    }

    public static void afisareLocuriDisponibile(Eveniment e){

            boolean gasit = false;
            for(Loc l:e.getLocuriEveniment().getLocuri()){
                if(l.getDisponibil()) {
                    System.out.println("Loc: " + l.getTip() + " " + l.getCod() + " pret:" + (e.getPretBilet() * l.getPretLoc()));
                    gasit = true;
                }
            }
            if(!gasit) System.out.println("Nu exista locuri disponibile");
    }

    public static Eveniment cautaEvenimentDupaNume(ArrayList<Eveniment> events, String nume){

        for(Eveniment E:events) {
            if(E.getNume().equals(nume)){
                return E;
            }
        }
        System.out.println("Nu exista spectacole cu acest nume");
        return null;
    }
    //returneaza doar filmele, opera sau teatru

    public static void cautaDoarOSublcasa(ArrayList<Eveniment> events,String subclasa){

        boolean gasit = false;
        for(Eveniment e:events){
            if(Objects.equals(e.getClass().getName(), "com.proiect.PAO."+subclasa)){
                e.afisare();
                System.out.print("\n");
                gasit = true;
            }
        }
        if(!gasit) System.out.println("Nu exista nici un eveniment de tipul: "+subclasa);

    }




}
