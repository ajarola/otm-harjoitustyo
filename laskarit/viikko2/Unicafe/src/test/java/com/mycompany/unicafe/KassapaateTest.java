/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

/**
 *
 * @author ajarola
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;



public class KassapaateTest {

    
    Maksukortti eiriittava;
    Maksukortti riittava;
    Kassapaate kassa;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        eiriittava = new Maksukortti(100);
        riittava = new Maksukortti(1000);
    }

    @Test
    public void luotuKassaOlemassa() {
        assertTrue(kassa!=null);      
    }
    
    @Test
    public void LuodunKassanRahamaaraTasmaa(){
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void LuodunKassanEdullisetTasmaa(){
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void LuodunKassanMaukkaatTasmaa(){
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void EdullisestiSyontiToimii(){
        kassa.syoEdullisesti(240);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void MaukkaastiSyontiToimii(){
        kassa.syoMaukkaasti(400);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
        
    @Test
    public void EdullisestiEiVoiSyodaLiianHalvalla(){
        kassa.syoEdullisesti(230);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void MaukkaastiEiVoiSyodaLiianHalvalla(){
        kassa.syoMaukkaasti(390);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void EdullisenMaksuSiirtyyKassaanOikein(){
        kassa.syoEdullisesti(500);
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void MaukkaanMaksuSiirtyyKassaanOikein(){
        kassa.syoMaukkaasti(500);
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void EdullisenVaihtorahaToimii(){
        assertEquals(100, kassa.syoEdullisesti(340));
    }
    
    @Test
    public void MaukkaanVaihtorahaToimii(){
        assertEquals(100, kassa.syoMaukkaasti(500));
    }
    
    @Test
    public void MaukkaanMaksuPalautetaanJosRahatEivatRiita(){
        assertEquals(100, kassa.syoMaukkaasti(100));
    }
    
    @Test
    public void EdullisenMaksuPalautetaanJosRahatEivatRiita(){
        assertEquals(100, kassa.syoEdullisesti(100));
    }
    
    @Test
    public void KassanRahamaaraSailyyJosEdullistaEiMyyda(){
        kassa.syoEdullisesti(1);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void KassanRahamaaraSailyyJosMaukastaEiMyyda(){
        kassa.syoMaukkaasti(1);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void EdullisenMaksuKortillaToimiiEikaLisaaRahamaaraa(){
        kassa.syoEdullisesti(riittava);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void MaukkaanMaksuKortillaToimiiEikaLisaaRahamaaraa(){
        kassa.syoMaukkaasti(riittava);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    @Test
    public void EdullisenMaksuKortillaLaskeeSaldoaOikein(){
        kassa.syoEdullisesti(riittava);
        assertEquals(760, riittava.saldo());
    }
    @Test
    public void MaukkaanMaksuKortillaLaskeeSaldoaOikein(){
        kassa.syoMaukkaasti(riittava);
        assertEquals(600, riittava.saldo());
    }
    
    @Test
    public void EdullisenMaksuKortillaPalauttaaTrue(){
        assertTrue(kassa.syoEdullisesti(riittava));
    }
    
    @Test
    public void MaukkaanMaksuKortillaPalauttaaTrue(){
        assertTrue(kassa.syoMaukkaasti(riittava));
    }
    
    @Test
    public void EdullisenKorttiMaksuLisaaMyydynLounaan(){
        kassa.syoEdullisesti(riittava);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void MaukkaanKorttiMaksuLisaaMyydynLounaan(){
        kassa.syoMaukkaasti(riittava);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void EpaonnistunutEdullisenOstoEiLaskeSaldoa(){
        kassa.syoEdullisesti(eiriittava);
        assertEquals(100, eiriittava.saldo());
    }
    
    @Test
    public void EpaonnistunutMaukkaanOstoEiLaskeSaldoa(){
        kassa.syoMaukkaasti(eiriittava);
        assertEquals(100, eiriittava.saldo());
    }
    
    @Test
    public void EpaonnistunutEdullisenOstoEiNostaMyytyja(){
        kassa.syoEdullisesti(eiriittava);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void EpaonnistunutMaukkaanOstoEiNostaMyytyja(){
        kassa.syoMaukkaasti(eiriittava);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void EpaonnistunutEdullisenOstoPalauttaaFalse(){
        assertFalse(kassa.syoEdullisesti(eiriittava));   
    }
    
    @Test
    public void EpaonnistunutMaukkaanOstoPalauttaaFalse(){
        assertFalse(kassa.syoMaukkaasti(eiriittava));   
    }
    
    @Test
    public void KortilleRahanLataaminenNostaaSaldoa(){
        kassa.lataaRahaaKortille(riittava, 1000);
        assertEquals(2000, riittava.saldo());
    }
    
    @Test
    public void KortilleRahanLataaminenLaskeeKassanRahamaaraa(){
        kassa.lataaRahaaKortille(riittava, 1000);
        assertEquals(101000, kassa.kassassaRahaa());
    }

    @Test
    public void KortilleNegatiivisenRahanLataaminenEiOnnistu(){
        kassa.lataaRahaaKortille(riittava, -1000);
        assertEquals(1000, riittava.saldo());
    }
    
    
    













}