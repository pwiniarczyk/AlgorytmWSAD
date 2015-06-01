/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorytmwsad;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Piotr
 */
public class InstancjaProblemuTest {
    
    public InstancjaProblemuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkIfCorrect method, of class InstancjaProblemu.
     */
    @Test
    public void testCheckIfCorrect() {
        System.out.println("checkIfCorrect");
        InstancjaProblemu instance = new InstancjaProblemu();
        ArrayList<Zadanie> lista = new ArrayList<>();
        
        for (int i = 0; i < 4; i++) {
            lista.add(new Zadanie(i, 3));
        }
        instance.setE(lista);
        instance.setTerminZakonczenia(15);
        instance.checkIfCorrect();
        // TODO review the generated test code and remove the default call to fail.
        
    }

       /**
     * Test of checkIfCorrect method, of class InstancjaProblemu.
     */
    @Test(expected = IllegalArgumentException.class)

    public void testCheckIfCorrectFailed() {
        System.out.println("checkIfCorrect");
        InstancjaProblemu instance = new InstancjaProblemu();
        ArrayList<Zadanie> lista = new ArrayList<>();
        
        for (int i = 0; i < 4; i++) {
            lista.add(new Zadanie(i, 3));
        }
        instance.setE(lista);
        instance.setTerminZakonczenia(10);
        instance.checkIfCorrect();
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    /**
     * Test sort
     */
    @Test
    public void testSort(){
        System.out.println("Sort");
        InstancjaProblemu instance = new InstancjaProblemu();
        ArrayList<Zadanie> lista = new ArrayList<>();
        lista.add(new Zadanie(1, 10));
        lista.add(new Zadanie(2, 20));
        lista.add(new Zadanie(3, 30));
        lista.add(new Zadanie(4, 40));
        lista.add(new Zadanie(5, 50));
        lista.add(new Zadanie(6, 60));        
        instance.setZadanie(lista);
        instance.sort();
        ArrayList<Zadanie> e = new ArrayList<>();
        e.add(new Zadanie(6, 60));
        e.add(new Zadanie(5, 50));
        e.add(new Zadanie(4, 40));
        e.add(new Zadanie(3, 30));
        e.add(new Zadanie(2, 20));
        e.add(new Zadanie(1, 10));
        assertEquals(instance.getZadanie().size(), e.size());
        for(int i=0; i<instance.getZadanie().size();i++){
         assertEquals(instance.getZadanie().get(i).getDlugosc(), e.get(i).getDlugosc());
         assertEquals(instance.getZadanie().get(i).getNumer(), e.get(i).getNumer());
        }

    }
    
    /**
     * Test of algorithm method, of class InstancjaProblemu.
     */
    @Test
    public void testAlgorithm() {
        System.out.println("algorithm");
        InstancjaProblemu instance = new InstancjaProblemu(6, 100, 1, 2);
        ArrayList<Zadanie> lista = new ArrayList<>();
        lista.add(new Zadanie(1, 30));
        lista.add(new Zadanie(2, 25));
        lista.add(new Zadanie(3, 15));
        lista.add(new Zadanie(4, 10));
        lista.add(new Zadanie(5, 5));
        lista.add(new Zadanie(6, 1));
        instance.setZadanie(lista);
        instance.algorithm();
        ArrayList<Zadanie> e = new ArrayList<>();
        e.add(new Zadanie(1, 30));
        e.add(new Zadanie(2, 25));
        e.add(new Zadanie(4, 10));
        e.add(new Zadanie(5, 5));
        ArrayList<Zadanie> t = new ArrayList<>();
        t.add(new Zadanie(6, 1));
        t.add(new Zadanie(3, 15));
        assertEquals(instance.getE().size(), e.size());
        for(int i=0; i<instance.getE().size();i++){
         assertEquals(instance.getE().get(i).getDlugosc(), e.get(i).getDlugosc());
         assertEquals(instance.getE().get(i).getNumer(), e.get(i).getNumer());
        }
        assertEquals(instance.getT().size(), t.size());
        for(int i=0; i<instance.getT().size();i++){
         assertEquals(instance.getT().get(i).getDlugosc(), t.get(i).getDlugosc());
         assertEquals(instance.getT().get(i).getNumer(), t.get(i).getNumer());
        }
        //assertEquals(instance.getT(), t);
        // TODO review the generated test code and remove the default call to fail.
    }

    
}
