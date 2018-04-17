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
    
}


    