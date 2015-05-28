/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorytmwsad;

import java.util.ArrayList;

/**
 *
 * @author Piotr
 */
public class AlgorytmWsad {

    

    public void calculate(){
       
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ParserPliku pp = new ParserPliku();
        InstancjaProblemu ip = pp.parse("test.txt");
        ip.algorithm();
        ip.wyswietl();
    }
    
}
