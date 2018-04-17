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
public class LaivanupotusTest {
    Player player;
    Board gameboard;
    Ship ship;
    public LaivanupotusTest() {
    
    
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
        assertEquals(5, gameboard.shiplist.size());
        
    }
    
    @Test
    public void testPlayerName(){
        assertEquals("Seppo", this.player.getName());
        
    }
    
    @Test
    public void testPlayerHasLost(){
        assertEquals(false, this.player.hasLost());
        
    }
    
    @Test
    public void testPlayerLives(){
        assertEquals(5, this.player.getLives());
        
    }
    
    @Test
    public void testPlayerAddLives(){
        this.player.addLives(5);
        assertEquals(10, this.player.getLives());
        
    }
    
    @Test
    public void testPlayerNegativeAddLives(){
        this.player.addLives(-5);
        assertEquals(5, this.player.getLives());
        
    }
    
    @Test
    public void testPlayerHit(){
        this.player.hit();
        assertEquals(4, this.player.getLives());
        
    }
    
    @Test
    public void testPlayerLosing(){
        this.player.hit();
        this.player.hit();
        this.player.hit();
        this.player.hit();
        this.player.hit();
        assertEquals(true, this.player.hasLost());
        
    }
        
    
    
}


    