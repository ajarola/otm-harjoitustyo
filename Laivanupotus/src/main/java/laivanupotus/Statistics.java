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
    public int turnsTaken;
    public String playerName;
    public String outcome;

    public Statistics(String player) {

        this.playerName = player;
        this.outcome = "Undecided";
        this.turnsTaken = 0;

    }

    public void recordStats() {

        try {
            this.writer = new PrintWriter(new FileWriter("statistics.txt", true));

            writer.println("Player: " + this.playerName + "   outcome:" + this.outcome + "   turns taken: " + this.turnsTaken);

            writer.close();

        } catch (IOException ex) {
            System.out.println("Something went wrong with recording the match statistics.");
        }

    }

}
