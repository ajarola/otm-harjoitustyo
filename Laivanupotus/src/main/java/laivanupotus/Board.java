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
        this.board = initializeArray(size);
        this.shiplist = new ArrayList();
    }

    public boolean shoot(int row, int column) {

        if (row >= this.board.length || column >= this.board.length) {
            System.out.println("Invalid input (not an integer) or shot out of bounds.");
            return false;
        }
        if (checkShipsForHits(row, column) == true) {
            this.owner.hit();
            return true;
        } else {
            return false;
        }
    }

    public void showOwnBoard() {
        int help = 0;
        System.out.println("\n");
        System.out.println("     0    1    2    3    4    5    6    7    8    9 \n");

        for (int i = 0; i < board.length; i++) {
            System.out.print(help + "    ");
            help++;
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

        int help = 0;
        System.out.println("\n");
        System.out.println("     0    1    2    3    4    5    6    7    8    9 \n");

        for (int i = 0; i < board.length; i++) {
            System.out.print(help + "    ");
            help++;
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

        //Laivojen sijoittaminen satunnaisesti pelikentälle. Ei tässä kohtaa rajoituksia laivojen sijainnin suhteen
        //toisiinsa nähden, paitsi, että eivät saa olla päällekkäin.
        Random shiplocator = new Random();

        int[] shiplengths = {5, 4, 3, 3, 2};
        String[] shipnames = {"Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer"};
        int k = 0;

        while (k < shiplengths.length) {

            int bowrow = shiplocator.nextInt(10);
            int bowcolumn = shiplocator.nextInt(10);
            int direction = shiplocator.nextInt(4);

            if (direction == 0) {
                if (addShipToBoard(bowrow, bowcolumn, bowrow + shiplengths[k] - 1, bowcolumn, shipnames[k]) == true) {
                    k++;
                }
            } else if (direction == 1) {
                if (addShipToBoard(bowrow, bowcolumn, bowrow, bowcolumn + shiplengths[k] - 1, shipnames[k]) == true) {
                    k++;
                }
            } else if (direction == 2) {
                if (addShipToBoard(bowrow, bowcolumn, bowrow - shiplengths[k] + 1, bowcolumn, shipnames[k]) == true) {
                    k++;
                }
            } else {
                if (addShipToBoard(bowrow, bowcolumn, bowrow, bowcolumn - shiplengths[k] + 1, shipnames[k]) == true) {
                    k++;
                }
            }

        }

    }

    public boolean addShipToBoard(int row1, int column1, int row2, int column2, String name) {

        // tarkistetaan, että laiva ei ole päätymässä out of bounds.
        if (row1 < 0 || column1 < 0 || row2 < 0 || column2 < 0 || row1 > this.board.length - 1 || column1 > this.board.length - 1 || row2 > this.board.length - 1 || column2 > this.board.length - 1) {
            return false;
        }

        // vaihdetaan päittäin, jos aloituspositio loppupositiota suurempi.
        if (row2 < row1) {
            int helper = row1;
            row1 = row2;
            row2 = helper;
        }

        if (column2 < column1) {
            int helper = column1;
            column1 = column2;
            column2 = helper;
        }

        int[][] position;
        int lenght;

        if (column1 == column2) {

            position = buildShipPositionRow(row1, row2, column1);
            lenght = row2 - row1 + 1;

        } else if (row1 == row2) {

            position = buildShipPositionColumn(row1, column1, column2);
            lenght = column2 - column1 + 1;

        } else {
            return false;
        }

        if (checkPositionLegality(position) == false) {
            return false;
        }

        shipLocationToBoard(position);

        this.shiplist.add(new Ship(lenght, position, name));
        this.owner.addLives(new Ship(lenght, position, name).lives);

        return true;
    }

    public int[][] initializeArray(int size) {

        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = -1;
            }
        }
        return array;
    }

    public void shipLocationToBoard(int[][] position) {

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {

                if (position[i][j] == 1) {
                    this.board[i][j] = 1;
                }
            }
        }
    }

    public boolean checkPositionLegality(int[][] position) {

        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position.length; j++) {
                if (position[i][j] == 1 && this.board[i][j] != -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] buildShipPositionRow(int startRow, int endRow, int column) {

        int[][] position = initializeArray(this.board.length);

        while (startRow <= endRow) {
            position[startRow][column] = 1;
            startRow++;
        }
        return position;
    }

    public int[][] buildShipPositionColumn(int row, int startColumn, int endColumn) {

        int[][] position = initializeArray(this.board.length);

        while (startColumn <= endColumn) {
            position[row][startColumn] = 1;
            startColumn++;
        }
        return position;
    }

    public boolean checkShipsForHits(int row, int column) {

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
}
