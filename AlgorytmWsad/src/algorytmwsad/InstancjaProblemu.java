/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorytmwsad;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Piotr
 */

public class InstancjaProblemu {
    private int liczbaZadan;
    private int terminZakonczenia;
    private int alfa;
    private int beta;
    private ArrayList<Zadanie> zadania;
    private ArrayList<Zadanie> t;
    private ArrayList<Zadanie> e;

    /**
     * Konstruktor bez parametrow. Tworzy nowe listy
     */
    public InstancjaProblemu(){
        zadania = new ArrayList<>();
        e = new ArrayList<>();
        t = new ArrayList<>();
    }
    /**
     * Konstuktor Instancji Problemu z parametrami
     * @param liczbaZadan liczba zadan w problemie
     * @param terminZakonczenia wspolny termin zakonczenia zadan
     * @param alfa wspolczynnik alfa
     * @param beta wspolczynnik beta
     */
    public InstancjaProblemu(int liczbaZadan, int terminZakonczenia, int alfa, int beta){
        this.liczbaZadan = liczbaZadan;
        this.terminZakonczenia = terminZakonczenia;
        this.alfa = alfa;
        this.beta = beta;
        zadania = new ArrayList<>();
        e = new ArrayList<>();
        t = new ArrayList<>();
    }
    
    public void sort(){
        zadania.sort(new Comparator<Zadanie>(){
            @Override
            public int compare (Zadanie zad1, Zadanie zad2){
                return zad1.compareTo(zad2);
            }
        });
    }
        
    /**
     * Metoda majaca na celu sprawdzenie czy problem mozna okreslic jako dowolny. W przypadku wykrycia restryktywnosci, rzucany jest wyjatek. 
     * Obliczane na podstawie: dlugosc zadan w zbiorze e < termin zakonczenia
     */
    public void checkIfCorrect(){
        int value=0;
        for (Zadanie zadanie : e) {
            value += zadanie.getDlugosc();
        }
        if(value>terminZakonczenia){
            throw new IllegalArgumentException("Problemu nie mozna rozwiazac, gdyz termin zakonczenia jest restryktywny");
        }
    }
    /**
     * Metoda odpowiedzialna za obliczenie algorytmu.
     */
    public void algorithm(){
        sort();
        for (Zadanie zadanie : zadania) {
            if(alfa*e.size()<beta*(t.size()+1)){
                e.add(zadanie);
            }else{
                t.add(0, zadanie);
            }
        }
        checkIfCorrect();
    }
    /**
     * @return the liczbaZadan
     */
    public int getLiczbaZadan() {
        return liczbaZadan;
    }

    /**
     * @param liczbaZadan the liczbaZadan to set
     */
    public void setLiczbaZadan(int liczbaZadan) {
        this.liczbaZadan = liczbaZadan;
    }

    /**
     * @return the terminZakonczenia
     */
    public int getTerminZakonczenia() {
        return terminZakonczenia;
    }

    /**
     * @param terminZakonczenia the terminZakonczenia to set
     */
    public void setTerminZakonczenia(int terminZakonczenia) {
        this.terminZakonczenia = terminZakonczenia;
    }

    /**
     * @return the alfa
     */
    public int getAlfa() {
        return alfa;
    }

    /**
     * @param alfa the alfa to set
     */
    public void setAlfa(int alfa) {
        this.alfa = alfa;
    }

    /**
     * @return the beta
     */
    public int getBeta() {
        return beta;
    }

    /**
     * @param beta the beta to set
     */
    public void setBeta(int beta) {
        this.beta = beta;
    }

    /**
     * @return the zadanie
     */
    public ArrayList<Zadanie> getZadanie() {
        return zadania;
    }

    /**
     * @param zadanie the zadanie to set
     */
    public void setZadanie(ArrayList<Zadanie> zadanie) {
        this.zadania = zadanie;
    }

    /**
     * @return the t
     */
    public ArrayList<Zadanie> getT() {
        return t;
    }

    /**
     * @param t the t to set
     */
    public void setT(ArrayList<Zadanie> t) {
        this.t = t;
    }

    /**
     * @return the e
     */
    public ArrayList<Zadanie> getE() {
        return e; 
    }

    /**
     * @param e the e to set
     */
    public void setE(ArrayList<Zadanie> e) {
        this.e = e;
    }

    void wyswietl() {
        System.out.println(liczbaZadan+ " " + terminZakonczenia + " "+ alfa+ " "+beta);
        System.out.println("Zadania: ");
        for (Zadanie zadanie : zadania) {
           System.out.println(zadanie.getNumer() + " " + zadanie.getDlugosc()); 
        }
        System.out.println("Zbior e: ");
        for (Zadanie zadanie : e) {
           System.out.println(zadanie.getNumer() + " " + zadanie.getDlugosc()); 
        }
        System.out.println("Zbior t: ");
        for (Zadanie zadanie : t) {
           System.out.println(zadanie.getNumer() + " " + zadanie.getDlugosc()); 
        }
        
    }
}
