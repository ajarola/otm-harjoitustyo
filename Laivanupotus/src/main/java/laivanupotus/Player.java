/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

/**
 *Luokka on pelaajan ilmentymä. Pelaajalla on nimi sek� pelilaudalla oleviin laivoihinsa perustuva määrä elämiä,
 * joiden loppuessa hän häviää pelin.
 * @author Aleksi
 */
public class Player {

    private String name;
    private int lives;

    public Player(String name) {

        this.name = name;
    }

 /**
 * Metodi vähentää pelaajan elämiä yhdellä. Käytetään kun kyseisen pelaajan laivoihin osuu.
 */
    public void hit() {
        this.lives--;
    }

    public int getLives() {
        return this.lives;
    }
 /**
 * Metodi lisää pelaajalle elämiä annetun luvun verran. Käytetään kun pelaajalle lisätään laivoja pelilaudalle.
 * Metodi myös tarkistaa, että annettu luku on positiivinen virheiden välttämiseksi.
 * @param amount Lisättävien elämien määrä
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
 * Metodin avulla saadaan tieto siitä, ovatko pelaajan elämät loppuneet eli toisin sanoen onko hän hävinnyt pelin.
 * @return Palauttaa true, jos pelaaja on hävinnyt pelin ja false mikäli tämä on vielä pelissä mukana.
 */
    public boolean hasLost() {
        if (this.lives > 0) {
            return false;
        } else {
            return true;
        }
    }
}
