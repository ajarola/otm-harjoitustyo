/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import java.io.*;

/**
 *Luokan avulla toteutetaan pelattujen pelien tulosten tallentaminen muistiin.
 * @author Aleksi
 */
public class Statistics {
    
    private FileReader reader;
    private PrintWriter writer;
    private int turnsTaken;
    private String playerName;
    private String outcome;

    public Statistics(String player) {

        this.playerName = player;
        this.outcome = "Undecided";
        this.turnsTaken = 0;

    }

/**
* Metodia käytetään pelin tulosten tallentamiseen. Tulokset tallennetaan statistics.txt nimiseen tekstitiedostoon, ja jos tällaista
* tiedostoa ei ole jo olemassa niin luodaan sellainen.
*/
    public void recordStats() {

        try {
            this.writer = new PrintWriter(new FileWriter("statistics.txt", true));

            writer.println("Player: " + this.playerName + "   outcome:" + this.outcome + "   turns taken: " + this.turnsTaken);

            writer.close();

        } catch (IOException ex) {
            System.out.println("Something went wrong with recording the match statistics.");
        }

    }

    
    public String getOutcome() {
        return this.outcome;
    }
    
    
    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
    
    
    public String getPlayerName() {
        return this.playerName;
    }
    
    public int getTurnsTaken() {
        return this.turnsTaken;
    }
/**
* Metodin avulla pidetään kirjaa pelissä käytetyistä vuoroista.
*/
    public void newTurn() {
        this.turnsTaken++;
    }
    
    
}
