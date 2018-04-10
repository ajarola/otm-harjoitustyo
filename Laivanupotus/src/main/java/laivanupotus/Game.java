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

    public Game() {

        this.scanner = new Scanner(System.in);
        this.opponentboard = new Board(5, 3);
        this.playerboard = new Board(5, 3);
        this.random = new Random();

        System.out.println("Use matrix rows and columns starting from 0 to target your shots.");
        System.out.println("  0 1 2 3 4");
        System.out.println("0 x x x x x");
        System.out.println("1 x x x x x");
        System.out.println("2 x x x x x");
        System.out.println("3 x x x x x");
        System.out.println("4 x x x x x");
        System.out.println("Game ends when other player's ships have been completely wiped out.");
        System.out.println("The upper board belongs to your opponent and lower one to you.");
        System.out.println("Opponent automatically takes a shot once your turn has ended unless you have won already.");
        System.out.println("To begin playing type your name:");

        this.player = new Player(scanner.nextLine());
        this.opponent = new Player("Opponent");

        while (this.player.hasLost() == false && this.opponent.hasLost() == false) {

            this.opponentboard.showOpponentBoard();
            System.out.print("---------------------");
            this.playerboard.showOwnBoard();

            System.out.println("type row to shoot");
            int row = this.scanner.nextInt();

            System.out.println("type column to shoot");
            int column = this.scanner.nextInt();

            if (this.opponentboard.shoot(row, column) == true) {
                this.opponent.hit();
                this.opponent.lose();
            }

            if (this.opponent.hasLost() == false) {

                boolean hasshot = false;

                while (hasshot == false) {

                    int randomrow = this.random.nextInt(5);
                    int randomcolumn = this.random.nextInt(5);

                    if (playerboard.board[randomrow][randomcolumn] != 2 && playerboard.board[randomrow][randomcolumn] != 0) {

                        hasshot = true;

                        if (this.playerboard.shoot(randomrow, randomcolumn) == true) {
                            this.player.hit();
                            this.player.lose();
                        }

                    }

                }

            }
        }

    }

}
