/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import java.util.ArrayList;

/**
 *
 * @author Aleksi
 */
public class Board {

    public ArrayList<Ship> shiplist;
    public int[][] board;

    public Board(int size, int ships) {

        this.board = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = -1;
            }
        }

        this.shiplist = new ArrayList<Ship>();

        for (int i = 0; i < ships; i++) {

            int[][] position = board;

            position[i][i] = 1;
            position[i + 1][i] = 1;
            position[i + 2][i] = 1;

            this.shiplist.add(new Ship(3, position));
        }

    }

    public boolean shoot(int row, int column) {

        for (Ship ship : this.shiplist) {

            if (ship.position[row][column] == 1) {
                this.board[row][column] = 1;
                ship.position[row][column] = -1;
                ship.hit();
                return true;
            }
        }
        this.board[row][column] = 0;
        return false;
    }

}
