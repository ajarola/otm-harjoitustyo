package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void KortinSaldoAlussaOikein(){
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void KortinLataaminenToimii(){
        kortti.lataaRahaa(200);
        assertEquals("saldo: 2.10", kortti.toString());
    }
    
    @Test
    public void KortinSaldoVaheneeOikein(){
        kortti.otaRahaa(10);
        assertEquals("saldo: 0.0", kortti.toString());
    }
    
    @Test
    public void KortinSaldoEiMuutuJosEiVaraaVahentaa(){
        kortti.otaRahaa(50);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void OtarahaaPalauttaaTrueJosTarpeeksiRahaa(){   
        assertTrue(kortti.otaRahaa(5));
    }
    
    @Test
    public void OtarahaaPalauttaaFalseJosEiTarpeeksiRahaa(){   
        assertFalse(kortti.otaRahaa(15));
    }
    
}
