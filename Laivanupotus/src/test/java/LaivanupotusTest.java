/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import laivanupotus.Board;
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
    
    Board board;
    
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
    
    this.board = new Board(5,3);
    
    
    }
    
    @After
    public void tearDown() {
    }

   
    
    @Test
    public void testShipCount(){
        assertEquals(3, board.shiplist.size());
        
    }
}


    