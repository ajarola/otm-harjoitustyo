/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

/**
 * Luokka kuvaa pelilaudalla olevia laivoja. Laivoilla on nimi, pituus, pituuteen perustuva m��r� el�mi�, sijainti sek� viel�
 * attribuutti, joka kertoo suoraan onko laiva jo uponnut vai edelleen pinnalla.
 * @author Aleksi
 */
public class Ship {

    private String name;
    private int lenght;
    private boolean sunk;
    private int lives;
    private int[][] position;

    public Ship(int lenght, int[][] position, String name) {

        this.lenght = lenght;
        this.sunk = false;
        this.lives = lenght;
        this.position = position;
        this.name = name;

    }

    public int[][] getPosition() {
        return this.position;
    }

    public int getLenght() {
        return this.lenght;
    }

    public int getLives() {
        return this.lives;
    }
/**
* Metodin avulla voidaan selvitt��, onko kyseinen laiva jo uponnut.
* @return Palauttaa true, jos laiva on uponnut ja false jos n�in ei ole.
*/
    public boolean isSunk() {
        return this.sunk;
    }
/**
* Metodin avulla v�hennet��n laivan el�mi� osuman sattuessa ja el�mien loppuessa upotetaan laiva.
*/
    public void hit() {
        if (this.lives > 0) {
            this.lives--;
        }
        sink();
    }

    public String getName() {
        return this.name;
    }
/**
* Metodin avulla vaihdetaan laivan uppoamisesta kertovalle attribuutille arvo true, mik�li laiva on uponnut.
* Hy�dynnet��n osana hit() metodia.
*/
    public void sink() {
        if (this.lives == 0) {
            this.sunk = true;
        }
    }

}
