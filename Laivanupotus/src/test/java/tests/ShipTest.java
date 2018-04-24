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
public class ShipTest {
    Player player;
    Board gameboard;
    Ship ship;
    public ShipTest() {
    
    
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

void testPlayerHasLost(){
        assertEquals(false, this.player.hasLost());
        
    }

    
        
    @Test
    public void testShipLenght(){
        assertEquals(5, this.gameboard.shiplist.get(0).getLenght());
        
    }
    
    @Test
    public void testShipName(){
        assertEquals("Destroyer", this.gameboard.shiplist.get(0).getName());
        
    }
    
    @Test
    public void testShipPosition(){
        assertEquals(1, this.gameboard.shiplist.get(0).position[0][0]);
        
    }
    
    @Test
    public void testShipHit(){
        this.gameboard.shiplist.get(0).hit();
        assertEquals(4, this.gameboard.shiplist.get(0).getLives());
        
    }
    
    @Test
    public void testShipNotSunk(){
        assertEquals(false, this.gameboard.shiplist.get(0).isSunk());
        
    }
    
    @Test
    public void testShipSinkingWhenHitEnough(){
        this.gameboard.shiplist.get(0).hit();
        this.gameboard.shiplist.get(0).hit();
        this.gameboard.shiplist.get(0).hit();
        this.gameboard.shiplist.get(0).hit();
        this.gameboard.shiplist.get(0).hit();
        assertEquals(true, this.gameboard.shiplist.get(0).isSunk());
        
    }
    
    
    
    
}


    