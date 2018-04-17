/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import java.io.*;

/**
 *
 * @author Aleksi
 */
public class Statistics {
    
    public FileReader reader;
    public PrintWriter writer;
    
    public Statistics(){

    }
    //Tänne tulee jossain kohtaa tulosten tallentamiseen liittyviä juttuja
    
    
 
    public void RecordStats(){
        
        try {
            writer = new PrintWriter("statistics.txt");

            writer.println("asdasdasd");
            
            writer.close();
    
        } catch (IOException ex) {
            System.out.println("Something went wrong");
        }
        
        
        
    }
    
    
    
    
}
