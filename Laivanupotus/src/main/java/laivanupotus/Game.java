/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;
import java.util.*;
/**
 *
 * @author Aleksi
 */
public class Game {
    
    public Scanner scanner;
    public Board opponentboard;
    public Board playerboard;
    public Player player;
    public Player opponent;
    public Random random;
    
    public Game(){
        
        this.scanner = new Scanner(System.in);
        this.opponentboard = new Board(5,3);
        this.playerboard = new Board(5,3);
        this.random = new Random();
        
        System.out.println("Type your name:");
        this.player = new Player(scanner.nextLine());
        this.opponent = new Player("Steve");
    
        System.out.println("The game begins");
    
        while (this.player.hasLost() == false && this.opponent.hasLost() == false){
            
            gameState();
            
            System.out.println("type row to shoot");
            int row = this.scanner.nextInt();
            
            System.out.println("type column to shoot");
            int column = this.scanner.nextInt();
            
            
            if (this.opponentboard.shoot(row, column)){
                opponent.hit();
            }
            
            if (opponent.hasLost() == false){
                if (this.playerboard.shoot(random.nextInt(4),random.nextInt(4))){
                    player.hit();
                }
            }
            
        }
        
        
        
        
        
    }
    
    
    
    
    public void gameState(){
        System.out.println(this.opponentboard.board);
        System.out.println("\n");
        System.out.println(this.playerboard.board);
    }
    
    
    
    
}
