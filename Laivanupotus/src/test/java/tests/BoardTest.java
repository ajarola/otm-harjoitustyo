package tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import laivanupotus.Board;
import laivanupotus.Player;
import laivanupotus.Ship;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Aleksi
 */
public class BoardTest {
    Player player;
    Board gameboard;
    Ship ship;
    int[][] position;
    
    public BoardTest() {
    
    
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    this.player = new Player("Seppo");
    this.gameboard = new Board(10,this.player);
    
    this.gameboard.addShipToBoard(0, 0, 0, 4, "Destroyer");
    
    this.position = new int[10][10];
    
    for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                position[i][j] = -1;
            }
    }
    this.position[0][0] = 1;
    this.position[0][1] = 1;
    
    
    
    }
            
   
    
    @After
    public void tearDown() {
    }

   
    
    @Test
    public void testBoardSize(){
        assertEquals(10, gameboard.board.length);
        
    }
    
    @Test
    public void testShootingOob(){
        assertEquals(false, gameboard.shoot(200,200));
        
    }
    
    @Test
    public void testShootHittingShip(){
        assertEquals(true, gameboard.shoot(0, 0));
        
    }
    
    @Test
    public void testShootNotCountingHitTwice(){
        gameboard.shoot(0, 0);
        assertEquals(false, gameboard.shoot(0,0));
        
    }
    
    @Test
    public void testShiplistSize(){
        assertEquals(1, gameboard.shiplist.size());
        
    }
    
    @Test
    public void testRandomBoardShipCount(){
        gameboard.randomBoard();
        assertEquals(6, gameboard.shiplist.size());
        
    }
    
    @Test
    public void initializeArrayLengthTest(){
        assertEquals(10, gameboard.initializeArray(10).length);
        
    }
    
    @Test
    public void initializeArrayValueTest(){
        assertEquals(-1, gameboard.initializeArray(10)[5][5]);
        
    }
    
    @Test
    public void ShipLocationToBoardShipTest(){
        gameboard.shipLocationToBoard(position);
        assertEquals(1, gameboard.board[0][0]);    
    }
    
    @Test
    public void ShipLocationToBoardWaterTest(){
        gameboard.shipLocationToBoard(position);
        assertEquals(-1, gameboard.board[5][5]);    
    }
    
    @Test
    public void CheckPositionLegalityIncorrectTest(){
        gameboard.shipLocationToBoard(position);
        assertEquals(false, gameboard.checkPositionLegality(position));    
    }
    
    @Test
    public void BuildShipPositionRowTest(){
        assertEquals(1, gameboard.buildShipPositionRow(5, 6, 0)[5][0]);    
    }
    
    @Test
    public void BuildShipPositionColumnTest(){
        assertEquals(1, gameboard.buildShipPositionColumn(6, 0, 4)[6][0]);    
    }
    
    @Test
    public void CheckShipsForHitsTrueTest(){
        assertEquals(true, gameboard.checkShipsForHits(0, 0));    
    }
    
    @Test
    public void CheckShipsForHitsFalseTest(){
        assertEquals(false, gameboard.checkShipsForHits(7, 7));    
    }
}


    