/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.*;
import laivanupotus.Board;
import laivanupotus.Player;
import laivanupotus.Statistics;

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
    public Statistics statistics;

    public Game() {

        this.scanner = new Scanner(System.in);

        this.random = new Random();

        System.out.println("Use matrix rows and columns starting from 0 to target your shots.");
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        System.out.println("0 x x x x x x x x x x");
        System.out.println("1 x x x x x x x x x x");
        System.out.println("2 x x x x x x x x x x");
        System.out.println("3 x x x x x x x x x x");
        System.out.println("4 x x x x x x x x x x");
        System.out.println("5 x x x x x x x x x x");
        System.out.println("6 x x x x x x x x x x");
        System.out.println("7 x x x x x x x x x x");
        System.out.println("8 x x x x x x x x x x");
        System.out.println("9 x x x x x x x x x x");
        System.out.println("Game ends when other player's ships have been completely wiped out.");
        System.out.println("The upper board belongs to your opponent and lower one to you.");
        System.out.println("Opponent automatically takes a shot once your turn has ended unless you have won already.");

        System.out.println("To begin playing type your name:");

        this.player = new Player(scanner.nextLine());
        this.opponent = new Player("Opponent");
        this.statistics = new Statistics(this.player.getName());
        this.opponentboard = new Board(10, this.opponent);
        this.playerboard = new Board(10, this.player);

        System.out.println("Type 1 to automatically place your ships or type 2 to place them manually:");

        int choice = 1;

        try {
            choice = Integer.parseInt(this.scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid user input. Your ships have been automatically placed, because you probably couldn't place them manually anyways.");
        }
        if (choice != 2) {
            this.playerboard.randomBoard();
        } else {

            System.out.println("The number of ships is 5. It's advisable to use the standard lengths 5, 4, 2 x 3 and 2 for the ships.");

            String[] shipnames = {"Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer"};
            int ships = 0;

            while (ships < 5) {

                System.out.println("To build a new ship type the start row and column for a ship, then type the end row and column for it:");

                int row1 = 999;
                int column1 = 999;
                int row2 = 999;
                int column2 = 999;

                try {
                    System.out.println("start row:");
                    row1 = Integer.parseInt(this.scanner.nextLine());
                    System.out.println("start column:");
                    column1 = Integer.parseInt(this.scanner.nextLine());
                    System.out.println("end row:");
                    row2 = Integer.parseInt(this.scanner.nextLine());
                    System.out.println("end column:");
                    column2 = Integer.parseInt(this.scanner.nextLine());
                } catch (NumberFormatException e) {

                }
                if (this.playerboard.addShipToBoard(row1, column1, row2, column2, shipnames[ships]) == true) {
                    ships++;
                    System.out.println("Ship succesfully added to your board.");
                } else {
                    System.out.println("Invalid input (not integer) or position for the ship.");
                }
                this.playerboard.showOwnBoard();
            }
            System.out.println("Your board is complete.");
        }

        this.opponentboard.randomBoard();

        System.out.println("Follow given instructions to play. If you want to end the game early, type negative value for row.");
        System.out.println("The game begins!");
        
        while (this.player.hasLost() == false && this.opponent.hasLost() == false) {

            this.statistics.turnsTaken++;

            showBoards();

            int row = 999;
            int column = 999;

            try {
                System.out.println("type row to shoot");
                row = Integer.parseInt(this.scanner.nextLine());
                System.out.println("type column to shoot");
                column = Integer.parseInt(this.scanner.nextLine());
            } catch (NumberFormatException e) {

            }

            if (row < 0) {
                break;
            }

            if (this.opponentboard.shoot(row, column) == true) {
                System.out.println("You hit a ship");
            }

            if (this.opponent.hasLost() == false) {

                boolean hasShot = false;

                while (hasShot == false) {
                    int randomrow = this.random.nextInt(10);
                    int randomcolumn = this.random.nextInt(10);
                    if (playerboard.board[randomrow][randomcolumn] != 2 && playerboard.board[randomrow][randomcolumn] != 0) {
                        hasShot = true;
                        this.playerboard.shoot(row, column);

                    }
                }
            }
        }
        announceWinner();
        
    }

    public void showBoards() {
        this.opponentboard.showOpponentBoard();
        System.out.print("---------------------------------------------------");
        this.playerboard.showOwnBoard();
    }

    public void announceWinner(){
        
        if (this.opponent.hasLost() == true) {
            System.out.println(this.player.getName() + " has won the match!");
        } else if (this.player.hasLost() == true) {
            System.out.println(this.player.getName() + " has lost the match!");
        }else{
            System.out.println("Match ended prematurely.");
        }     
        record();    
    }
    
    public void record() {

        if (this.opponent.hasLost() == true) {
            this.statistics.outcome = "win";
        } else if (this.player.hasLost() == true) {
            this.statistics.outcome = "lose";
        }
        this.statistics.recordStats();
    }

    public static void main(String[] args) throws Exception {
        
        Game game = new Game();
        
    }
    
    
}
