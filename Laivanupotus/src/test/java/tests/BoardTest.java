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
        assertEquals(10, gameboard.getBoard().length);
        
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
        assertEquals(1, gameboard.getShiplist().size());
        
    }
    
    @Test
    public void testRandomBoardShipCount(){
        gameboard.randomBoard();
        assertEquals(6, gameboard.getShiplist().size());
        
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
    public void shipLocationToBoardShipTest(){
        gameboard.shipLocationToBoard(position);
        assertEquals(1, gameboard.getBoard()[0][0]);    
    }
    
    @Test
    public void shipLocationToBoardWaterTest(){
        gameboard.shipLocationToBoard(position);
        assertEquals(-1, gameboard.getBoard()[5][5]);    
    }
    
    @Test
    public void checkPositionLegalityIncorrectTest(){
        gameboard.shipLocationToBoard(position);
        assertEquals(false, gameboard.checkPositionLegality(position));    
    }
    
    @Test
    public void buildShipPositionRowTest(){
        assertEquals(1, gameboard.buildShipPosition(5, 6, 0, 0)[5][0]);    
    }
    
    @Test
    public void buildShipPositionColumnTest(){
        assertEquals(1, gameboard.buildShipPosition(6, 6, 0, 4)[6][0]);    
    }
    
    @Test
    public void checkShipsForHitsTrueTest(){
        assertEquals(true, gameboard.checkShipsForHits(0, 0));    
    }
    
    @Test
    public void checkShipsForHitsFalseTest(){
        assertEquals(false, gameboard.checkShipsForHits(7, 7));    
    }
    
    @Test
    public void addShipToBoardFailTest(){
        assertEquals(false, gameboard.addShipToBoard(999, 6, 0, 0, "Seppo"));    
    }
    
    @Test
    public void addShipToBoardFail1Test(){
        assertEquals(false, gameboard.addShipToBoard(6, 999, 0, 0, "Seppo"));    
    }
    
    @Test
    public void addShipToBoardFail2Test(){
        assertEquals(false, gameboard.addShipToBoard(-1, 6, 0, 0, "Seppo"));    
    }
    
    @Test
    public void addShipToBoardFail3Test(){
        assertEquals(false, gameboard.addShipToBoard(6, -1, 0, 0, "Seppo"));    
    }
    
    @Test
    public void addShipToBoardFail4Test(){
        assertEquals(false, gameboard.addShipToBoard(6, 6, -1, 0, "Seppo"));    
    }
    
    @Test
    public void addShipToBoardFail5Test(){
        assertEquals(false, gameboard.addShipToBoard(6, 5, 0, -1, "Seppo"));    
    }
    
    @Test
    public void addShipToBoardFail6Test(){
        assertEquals(false, gameboard.addShipToBoard(0, 0, 999, 0, "Seppo"));    
    }
    
    @Test
    public void addShipToBoardFail7Test(){
        assertEquals(false, gameboard.addShipToBoard(0, 0, 0, 999, "Seppo"));    
    }
    
    @Test
    public void addShipToBoardFailLaterTest(){
        assertEquals(false, gameboard.addShipToBoard(5, 6, 7, 8, "Seppo"));    
    } 
}


    