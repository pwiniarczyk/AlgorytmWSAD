/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorytmwsad;

/**
 *
 * @author Piotr
 */
public class Zadanie {
    private int numer;
    private int dlugosc;
    
    public Zadanie(int numer, int dlugosc){
        this.numer = numer;
        this.dlugosc = dlugosc;
    }
    /**
     * @return the numer
     */
    public int getNumer() {
        return numer;
    }

    /**
     * @param numer the numer to set
     */
    public void setNumer(int numer) {
        this.numer = numer;
    }

    /**
     * @return the dlugosc
     */
    public int getDlugosc() {
        return dlugosc;
    }

    /**
     * @param dlugosc the dlugosc to set
     */
    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
    }
    
}
