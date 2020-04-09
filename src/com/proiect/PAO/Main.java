package com.proiect.PAO;

import java.text.ParseException;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws ParseException {
	Client c = new Client("Gigel",29,"gigel.ionescu@yahoo.com");
	ArrayList<Eveniment> Events = new ArrayList<>();

    Locuri Sala = new Locuri(new int[]{50, 50, 30, 30, 15, 15, 5, 5});
    Sala.creareLocuri();

    Locuri Sala1 = new Locuri(new int[]{60, 60, 30, 30, 20, 20, 10, 10});
    Sala1.creareLocuri();

    Teatru teatru = new Teatru("Nume de Teatru",100,"drama",2,"Feb 28, 2020",Sala,"nume trupa","nume regizor");
    Events.add(teatru);

    Opera opera = new Opera("Nume Opera", 200, "tragic",3,"Mar 13, 2020", Sala1,"Trupa Opera","Orchestra", "Dirijor" );
    Events.add(opera);

    Locuri Sala2 = new Locuri(new int[]{40, 40, 30, 30, 10, 10, 0, 0});
    Sala2.creareLocuri();

    Film film = new Film("Nume Film", 20,"comedie", 1,"Apr 12, 2020",Sala2,2,"romana",false);
    Events.add(film);

    Locuri Sala3 = new Locuri(new int[]{50, 50, 30, 30, 15, 15, 5, 5});
    Concert concert = new Concert("Nume Concert", 50, "rock", 4,"Apr 20, 2021",Sala3,"Artist","live");

    Events.add(concert);
    //caut evenimentul dupa nume

    Eveniment e = ClientService.cautaEvenimentDupaNume(Events,"Nume de Teatru");

    // afisare locuri disponibile la un anumit spectacol
    ClientService.afisareLocuriDisponibile(e);

    //rezerva bilet
    ClientService.rezervareBilet(e, 26,"normal",c);

    //afisare locuri rezervate de cliente
    ClientService.afisareLocuriRezervate(c);

    //anuleaza rezervarea la un anumit spectacol
    ClientService.anuleazaRezervarea(e,c);

    ClientService.afisareLocuriRezervate(c);

    //afiseaza evenimentele la care mai sunt locuri disponibile
    ClientService.AfiseazaToateEvenimenteleDisponibile(Events);

    //caut evenimente dupa gen
    ClientService.cautareEvenimenteDupaGen(Events,"comedie");

    //caut locurile de un anumit tip disponibile la evenimentul e
    ClientService.cautareLocuri(e,"VIP");

    //caut doar evenimentele de un anumit tip: opera, film etc

    ClientService.cautaDoarOSublcasa(Events, "Opera");

    //caut evenient dupa data
    ClientService.cautareEvenimenteInData(Events,"Feb 30, 2020");


    ClientService.rezervareBilet(e,26,"normal",c);

    //schimb un bilet rezervat
    ClientService.schimbaLocul(e,46,"VIP",c);
    }
}
