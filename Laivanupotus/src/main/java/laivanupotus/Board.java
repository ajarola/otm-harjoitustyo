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

    public Board(int size) {

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

    public void randomBoard(int shipnumber) {

        while (this.shiplist.size() < shipnumber) {

            int[][] position = new int[this.board.length][this.board.length];

            for (int i = 0; i < this.board.length; i++) {
                for (int j = 0; j < this.board.length; j++) {
                    position[i][j] = -1;
                }
            }

            //Laivojen sijoittaminen satunnaisesti pelikentälle. Ei tässä kohtaa rajoituksia laivojen sijainnin suhteen
            //toisiinsa nähden, paitsi, että eivät saa olla päällekkäin.
            Random shiplocator = new Random();

            int checkpos = 0;
            int bowrow = shiplocator.nextInt(5);
            int bowcolumn = shiplocator.nextInt(5);
            int direction = shiplocator.nextInt(4);

            if (direction == 0 && bowrow + 2 < 5 && this.board[bowrow][bowcolumn] == -1 && this.board[bowrow + 1][bowcolumn] == -1 && this.board[bowrow + 2][bowcolumn] == -1) {
                checkpos++;
                position[bowrow][bowcolumn] = 1;
                position[bowrow + 1][bowcolumn] = 1;
                position[bowrow + 2][bowcolumn] = 1;
                this.board[bowrow][bowcolumn] = 1;
                this.board[bowrow + 1][bowcolumn] = 1;
                this.board[bowrow + 2][bowcolumn] = 1;
            } else if (direction == 1 && bowrow - 2 > 0 && this.board[bowrow][bowcolumn] == -1 && this.board[bowrow - 1][bowcolumn] == -1 && this.board[bowrow - 2][bowcolumn] == -1) {
                checkpos++;
                position[bowrow][bowcolumn] = 1;
                position[bowrow - 1][bowcolumn] = 1;
                position[bowrow - 2][bowcolumn] = 1;
                this.board[bowrow][bowcolumn] = 1;
                this.board[bowrow - 1][bowcolumn] = 1;
                this.board[bowrow - 2][bowcolumn] = 1;
            } else if (direction == 2 && bowcolumn + 2 < 5 && this.board[bowrow][bowcolumn] == -1 && this.board[bowrow][bowcolumn + 1] == -1 && this.board[bowrow][bowcolumn + 2] == -1) {
                checkpos++;
                position[bowrow][bowcolumn] = 1;
                position[bowrow][bowcolumn + 1] = 1;
                position[bowrow][bowcolumn + 2] = 1;
                this.board[bowrow][bowcolumn] = 1;
                this.board[bowrow][bowcolumn + 1] = 1;
                this.board[bowrow][bowcolumn + 2] = 1;
            } else if (direction == 3 && bowcolumn - 2 > 0 && this.board[bowrow][bowcolumn] == -1 && this.board[bowrow][bowcolumn - 1] == -1 && this.board[bowrow][bowcolumn - 2] == -1) {
                checkpos++;
                position[bowrow][bowcolumn] = 1;
                position[bowrow][bowcolumn - 1] = 1;
                position[bowrow][bowcolumn - 2] = 1;
                this.board[bowrow][bowcolumn] = 1;
                this.board[bowrow][bowcolumn - 1] = 1;
                this.board[bowrow][bowcolumn - 2] = 1;
            }

            if (checkpos == 1) {

                this.shiplist.add(new Ship(3, position));
            }

        }

    }

    public boolean addShipToBoard(int row1, int column1, int row2, int column2) {

        // tarkistetaan, että laiva ei ole päätymässä out of bounds.
        if (row1 < 0 || column1 < 0 || row2 < 0 || column2 < 0 || row1 > this.board.length - 1 || column1 > this.board.length - 1 || row2 > this.board.length - 1 || column2 > this.board.length - 1) {
            return false;
        }

        int[][] position = new int[this.board.length][this.board.length];

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                position[i][j] = -1;
            }
        }

        int midrow;
        int midcolumn;

        if (column1 == column2) {

            midcolumn = column1;

            if (row1 < row2) {
                midrow = row1 + 1;
            } else {
                midrow = row2 + 1;
            }

        } else if (row1 == row2) {

            midrow = row1;

            if (column1 < column2) {
                midcolumn = column1 + 1;
            } else {
                midcolumn = column2 + 1;
            }

        } else {
            return false;
        }

        //tarkistetaan, että sijainnissa ei ole jo laivaa
        if (this.board[row1][column1] == 1 || this.board[midrow][midcolumn] == 1 || this.board[row2][column2] == 1) {
            return false;
        }

        position[row1][column1] = 1;
        position[midrow][midcolumn] = 1;
        position[row2][column2] = 1;
        this.board[row1][column1] = 1;
        this.board[midrow][midcolumn] = 1;
        this.board[row2][column2] = 1;

        this.shiplist.add(new Ship(3, position));

        return true;

    }

}
