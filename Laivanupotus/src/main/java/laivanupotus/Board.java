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
public class Board {

    public ArrayList<Ship> shiplist;
    public int[][] board;
    public Player owner;

    public Board(int size, Player owner) {

        this.owner = owner;

        this.board = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = -1;
            }
        }

        this.shiplist = new ArrayList<>();

    }

    public boolean shoot(int row, int column) {

        if (row >= this.board.length || column >= this.board.length) {
            System.out.println("Shot out of bounds.");
            return false;
        }

        for (Ship ship : this.shiplist) {

            if (ship.getPosition()[row][column] == 1) {
                this.board[row][column] = 2;

                ship.getPosition()[row][column] = -1;
                ship.hit();
                return true;
            }

        }

        if (this.board[row][column] != 2) {
            this.board[row][column] = 0;
        }
        return false;
    }

    public void showOwnBoard() {

        System.out.println("\n");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (this.board[i][j] == -1) {
                    System.out.print("~" + "    ");
                } else if (this.board[i][j] == 1) {
                    System.out.print("S" + "    ");
                } else if (this.board[i][j] == 2) {
                    System.out.print("X" + "    ");
                } else {
                    System.out.print("O" + "    ");
                }
            }
            System.out.println("\n");
        }

    }

    public void showOpponentBoard() {

        System.out.println("\n");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (this.board[i][j] == -1 || this.board[i][j] == 1) {
                    System.out.print("~" + "    ");
                } else if (this.board[i][j] == 2) {
                    System.out.print("X" + "    ");
                } else {
                    System.out.print("O" + "    ");
                }
            }
            System.out.println("\n");
        }

    }

    public void randomBoard() {

        while (this.shiplist.size() < 5) {

            int[][] position = new int[this.board.length][this.board.length];

            for (int i = 0; i < this.board.length; i++) {
                for (int j = 0; j < this.board.length; j++) {
                    position[i][j] = -1;
                }
            }

            //Laivojen sijoittaminen satunnaisesti pelikentälle. Ei tässä kohtaa rajoituksia laivojen sijainnin suhteen
            //toisiinsa nähden, paitsi, että eivät saa olla päällekkäin.
            Random shiplocator = new Random();

            int[] shiplengths = {5, 4, 3, 3, 2};

            int k = 0;
            
            while(k < shiplengths.length) {

                int bowrow = shiplocator.nextInt(10);
                int bowcolumn = shiplocator.nextInt(10);
                int direction = shiplocator.nextInt(4);
                
                if (direction == 0){
                if (addShipToBoard(bowrow,bowcolumn,bowrow+shiplengths[k]-1,bowcolumn) == true){
                    k++;
                }
                } else if (direction == 1){
                if (addShipToBoard(bowrow,bowcolumn,bowrow,bowcolumn+shiplengths[k]-1) == true){
                    k++;
                }
                } else if (direction == 2){
                if (addShipToBoard(bowrow,bowcolumn,bowrow-shiplengths[k]+1,bowcolumn) == true){
                    k++;
                }
                } else {
                if (addShipToBoard(bowrow,bowcolumn,bowrow,bowcolumn-shiplengths[k]+1) == true)
                    k++;
                }
 
            }

        }
    }

    public boolean addShipToBoard(int row1, int column1, int row2, int column2) {

        // tarkistetaan, että laiva ei ole päätymässä out of bounds.
        if (row1 < 0 || column1 < 0 || row2 < 0 || column2 < 0 || row1 > this.board.length - 1 || column1 > this.board.length - 1 || row2 > this.board.length - 1 || column2 > this.board.length - 1) {
            return false;
        }

        // vaihdetaan päittäin, jos aloituspositio loppupositiota suurempi.
        if (row2 < row1){
            int helper = row1;
            row1 = row2;
            row2 = helper;        
        }
        
        if (column2 < column1){
            int helper = column1;
            column1 = column2;
            column2 = helper;        
        }
        
        
        int[][] position = new int[this.board.length][this.board.length];

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                position[i][j] = -1;
            }
        }

        int lenght;

        if (column1 == column2) {

            lenght = row2 - row1 + 1;
            int midrow = row1;

            while (midrow <= row2) {

                if (this.board[midrow][column1] != -1) {
                    return false;
                }

                position[midrow][column1] = 1;
                
                midrow++;
            }

        } else if (row1 == row2) {

            lenght = column2 - column1 + 1;
            int midcolumn = column1;

            while (midcolumn <= column2) {

                if (this.board[row1][midcolumn] != -1) {
                    return false;
                }

                position[row1][midcolumn] = 1;
                
                midcolumn++;
            }

        } else {
            return false;
        }

        
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                if (position[i][j] == 1){
                    this.board[i][j] = 1;
                }
            }
        }
        
        
        
        
        Ship ship = new Ship(lenght, position);

        this.shiplist.add(ship);

        this.owner.addLives(ship.lives);

        return true;

    }

}
