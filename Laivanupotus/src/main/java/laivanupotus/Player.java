/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

/**
 *Luokka on pelaajan ilmentym�. Pelaajalla on nimi sek� pelilaudalla oleviin laivoihinsa perustuva m��r� el�mi�,
 * joiden loppuessa h�n h�vi�� pelin.
 * @author Aleksi
 */
public class Player {

    private String name;
    private int lives;

    public Player(String name) {

        this.name = name;
    }

 /**
 * Metodi v�hent�� pelaajan el�mi� yhdell�. K�ytet��n kun kyseisen pelaajan laivoihin osuu.
 */
    public void hit() {
        this.lives--;
    }

    public int getLives() {
        return this.lives;
    }
 /**
 * Metodi lis�� pelaajalle el�mi� annetun luvun verran. K�ytet��n kun pelaajalle lis�t��n laivoja pelilaudalle.
 * Metodi my�s tarkistaa, ett� annettu luku on positiivinen virheiden v�ltt�miseksi.
 */
    public void addLives(int amount) {
        if (amount > 0) {
            this.lives = this.lives + amount;
        }
    }

    public String getName() {
        return this.name;
    }
 /**
 * Metodin avulla saadaan tieto siit�, ovatko pelaajan el�m�t loppuneet eli toisin sanoen onko h�n h�vinnyt pelin.
 * @return Palauttaa true, jos pelaaja on h�vinnyt pelin ja false mik�li t�m� on viel� peliss� mukana.
 */
    public boolean hasLost() {
        if (this.lives > 0) {
            return false;
        } else {
            return true;
        }
    }
}
