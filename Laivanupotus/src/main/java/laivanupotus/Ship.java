/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

/**
 *
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

    public boolean isSunk() {
        return this.sunk;
    }

    public void hit() {
        if (this.lives > 0) {
            this.lives--;
        }
        sink();
    }

    public String getName() {
        return this.name;
    }

    public void sink() {
        if (this.lives == 0) {
            this.sunk = true;
        }
    }

}
