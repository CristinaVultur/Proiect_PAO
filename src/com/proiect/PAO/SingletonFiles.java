package com.proiect.PAO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;


public class SingletonFiles {


    private static SingletonFiles instance;

    private SingletonFiles() {
    }

    public static SingletonFiles getInstance() {
        if (instance == null) {
            synchronized (SingletonFiles.class) {
                if (instance == null) {
                    instance = new SingletonFiles();
                }
            }
        }
        return instance;

    }

    public static ArrayList<Client> readClienti(String csvFile) {

        ArrayList<Client> vector = new ArrayList<>();
        try {
            for (String line : Files.readAllLines(Paths.get(csvFile))) {
                String[] values = line.split(",");
                vector.add(new Client(values[0],Integer.parseInt(values[1]),values[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vector;
    }

    public static void writeClient(String csvFile, Client client) throws IOException {//adaug un nou client in lista din csv

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile,true))) {

                writer.newLine();
                writer.write(client.getNume());
                writer.write(",");
                writer.write(Integer.toString(client.getVarsta()));
                writer.write(",");
                writer.write(client.getMail());

        }
    }
    public static Locuri serviceCreareLocuri(String locuri){

        String[] locuriString = locuri.split(" ");
        int []int_locuri = new int[8];
        for(int i=0; i<locuriString.length;i++){
            int_locuri[i]=Integer.parseInt(locuriString[i]);
        }
        Locuri l = new Locuri(int_locuri);
        l.creareLocuri();
        return l;
    }

    public static ArrayList<Eveniment> citireTeatru(String csvFile){

        ArrayList<Eveniment> vector = new ArrayList<>();
        try {
            for (String line : Files.readAllLines(Paths.get(csvFile))) {
                String[] values = line.split(",");
                String nume = values[0];
                int pret = Integer.parseInt(values[1]);
                String gen = values[2];
                int durata = Integer.parseInt(values[3]);
                String data = values[4];
                Locuri locuri= instance.serviceCreareLocuri(values[5]);
                String trupa = values[6];
                String regizor = values[7];
                vector.add(new Teatru(nume,pret,gen,durata,data,locuri,trupa,regizor));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return vector;
    }
    public static void writeEvent(Eveniment e, BufferedWriter writer) throws IOException, ParseException {

        writer.newLine();
        writer.write(e.getNume());
        writer.write(",");
        writer.write(Integer.toString(e.getPretBilet()));
        writer.write(",");
        writer.write(e.getGen());
        writer.write(",");
        writer.write(Integer.toString(e.getDurata()));
        writer.write(",");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        writer.write(format.format(e.getData()));
        writer.write(",");
        StringBuilder stringBuilder = new StringBuilder();
        Locuri l = e.getLocuriEveniment();
        for (int value:l.getProp().values()) {
            stringBuilder.append(Integer.toString(value));
            stringBuilder.append(" ");
        }
        writer.write(String.valueOf(stringBuilder));
        writer.write(",");

    }
    public static void writeTeatru(String csvFile, Teatru teatru) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile,true))) {
                instance.writeEvent(teatru,writer);
                writer.write(teatru.getTrupa());
                writer.write(",");
                writer.write(teatru.getRegizor());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Eveniment> citireConcert(String csvFile){

        ArrayList<Eveniment> vector = new ArrayList<>();
        try {
            for (String line : Files.readAllLines(Paths.get(csvFile))) {
                String[] values = line.split(",");
                String nume = values[0];
                int pret = Integer.parseInt(values[1]);
                String gen = values[2];
                int durata = Integer.parseInt(values[3]);
                String data = values[4];
                Locuri locuri= instance.serviceCreareLocuri(values[5]);
                String numeArtist = values[6];
                vector.add(new Concert(nume,pret,gen,durata,data,locuri,numeArtist));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return vector;
    }
    public static void writeConcert(String csvFile, Concert concert) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile,true))) {
            instance.writeEvent(concert,writer);
            writer.write(concert.getNumeArtist());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Eveniment> citireOpera(String csvFile){

        ArrayList<Eveniment> vector = new ArrayList<>();
        try {
            for (String line : Files.readAllLines(Paths.get(csvFile))) {
                String[] values = line.split(",");
                String nume = values[0];
                int pret = Integer.parseInt(values[1]);
                String gen = values[2];
                int durata = Integer.parseInt(values[3]);
                String data = values[4];
                Locuri locuri= instance.serviceCreareLocuri(values[5]);
                String numeTrupa = values[6];
                String orchestra = values[7];
                String dirijor = values[8];
                vector.add(new Opera(nume,pret,gen,durata,data,locuri,numeTrupa,orchestra,dirijor));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return vector;
    }
    public static void writeOpera(String csvFile, Opera opera) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile,true))) {
            instance.writeEvent(opera,writer);
            writer.write(opera.getTrupa());
            writer.write(",");
            writer.write(opera.getOrchestra());
            writer.write(",");
            writer.write(opera.getDirijor());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Eveniment> citireFilm(String csvFile){

        ArrayList<Eveniment> vector = new ArrayList<>();
        try {
            for (String line : Files.readAllLines(Paths.get(csvFile))) {
                String[] values = line.split(",");
                String nume = values[0];
                int pret = Integer.parseInt(values[1]);
                String gen = values[2];
                int durata = Integer.parseInt(values[3]);
                String data = values[4];
                Locuri locuri= instance.serviceCreareLocuri(values[5]);
                int xD = Integer.parseInt(values[6]);
                String limba = values[7];
                boolean dublat = Boolean.parseBoolean(values[8]);
                vector.add(new Film(nume,pret,gen,durata,data,locuri,xD,limba,dublat));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return vector;
    }
    public static void writeFilm(String csvFile, Film film) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile,true))) {
            instance.writeEvent(film,writer);
            writer.write(Integer.toString(film.getxD()));
            writer.write(",");
            writer.write(film.getSubtitrari());
            writer.write(",");
            writer.write(Boolean.toString(film.isDublat()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}