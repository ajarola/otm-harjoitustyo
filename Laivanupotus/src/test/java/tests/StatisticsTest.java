/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * @author ajarola
 */
import java.io.IOException;
import laivanupotus.Statistics;
import laivanupotus.Player;
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
public class StatisticsTest {
    Player player;
    Statistics statistics;
    
    public StatisticsTest() {
    
    
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
    this.statistics = new Statistics(this.player.getName());

    }

    @After
    public void tearDown() {
    }


    @Test
    public void testGetOutcome(){
        assertEquals("Undecided", this.statistics.getOutcome());
    }
    
    @Test
    public void testSetOutcome(){
        this.statistics.setOutcome("Victory");
        assertEquals("Victory", this.statistics.getOutcome());
    }

    @Test
    public void testGetPlayerName() {
        assertEquals("Seppo", this.statistics.getPlayerName());
    }

    @Test
    public void testNewTurnAndGetTurns(){
        this.statistics.newTurn();
        assertEquals(1, this.statistics.getTurnsTaken());
    }
    
    @Test
    public void testRecordStats() throws IOException{
        this.statistics.recordStats();
        assertEquals(0, this.statistics.getTurnsTaken());
    }
    
}