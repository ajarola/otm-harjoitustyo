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
public class Player {

    public String name;
    public int lives;

    public Player(String name) {

        this.name = name;
    }

    public void hit() {
        this.lives--;
    }

    public int getLives() {
        return this.lives;
    }

    public void addLives(int amount) {

        if (amount > 0) {
            this.lives = this.lives + amount;
        }
    }

    public String getName() {
        return this.name;
    }

    public boolean hasLost() {
        if (this.lives > 0) {
            return false;
        } else {
            return true;
        }
    }
}
