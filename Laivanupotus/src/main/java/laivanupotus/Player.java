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
    
    public Player(String name){
        
        this.name = name;
        this.lives = 1;
    }
    
    public void hit(){
        this.lives--;
    }
    
    public int getLives(){
        return this.lives;
    }
    
    public String getName(){
        return this.name;
    }
    
    public boolean hasLost(){
        if (this.lives > 0){
            return false;
        }else 
            return true;
    }
    
    
    public void lose(){
        if (this.lives <= 0){
            System.out.println(this.name + " has lost the game");
        }
    }
    
    
}
