
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorytmwsad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Piotr
 */
public class ParserPliku {
    
    public void tworzProblem(int numerLinii, String CurrentLine, InstancjaProblemu problem){
        
        String delims = "[\\^\t ]"; // so the delimiters are:  + - * / ^ space
        //String signs = "[\+\- ]";
        //String signs = "/[+-]/"; // so the delimiters are:  + - * / ^ space
        String[] tokens = CurrentLine.split(delims);
        if(numerLinii==0){
            try{
                if(tokens[0].contains("+") || tokens[0].contains("-") || tokens[1].contains("-") || tokens[1].contains("+") || tokens[2].contains("+") || tokens[2].contains("-") || tokens[3].contains("-") || tokens[2].contains("+")){
                    throw new IllegalArgumentException("String not in correct format");
                }
                problem.setLiczbaZadan(Integer.parseInt(tokens[0]));
                problem.setTerminZakonczenia(Integer.parseInt(tokens[1]));
                problem.setAlfa(Integer.parseInt(tokens[2]));
                problem.setBeta(Integer.parseInt(tokens[3]));
            }
            catch(Exception e){
                throw new IllegalArgumentException("String not in correct format");
            }
            if (tokens.length != 4) 
                throw new IllegalArgumentException("String not in correct format");
            
        } else if(numerLinii==1){
            if (tokens.length != problem.getLiczbaZadan()) 
                throw new IllegalArgumentException("String not in correct format");
            for (int i = 0; i < tokens.length; i++) {
                try{
                if(tokens[i].contains("+") || tokens[i].contains("-")){
                    throw new IllegalArgumentException("String not in correct format");
                }
                Zadanie zadanie = new Zadanie(i+1,Integer.parseInt(tokens[i]));
                problem.getZadanie().add(zadanie);
                }
                catch(Exception e){
                    throw new IllegalArgumentException("String not in correct format");
            }
            }  
        }else{
            throw new IllegalArgumentException("String not in correct format");
        }
    }
    public InstancjaProblemu parse(String path){
        InstancjaProblemu problem = new InstancjaProblemu();
        BufferedReader br = null;
        int linia=0;
        
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(path));
 
			while ((sCurrentLine = br.readLine()) != null) {
                                tworzProblem(linia, sCurrentLine, problem);
                                linia++;
			}
 
		} catch (IOException e) {
			throw new IllegalArgumentException("String not in correct format");
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
                
        return problem;
    }
    

        
    
}
