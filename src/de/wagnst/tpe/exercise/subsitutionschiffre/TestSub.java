package de.wagnst.tpe.exercise.subsitutionschiffre;

import org.junit.Test;
import static org.junit.Assert.*;
import de.wagnst.tpe.exercise.crypter.*;

public class TestSub {
                       // ABCDEFGHIJKLMNOPQRSTUVWXYZ
    private String key = "DEFGHIJKLMNOPQRSTUVWXYZABC";

    @Test
    public void testVerschluessln() {

        Crypter test = new Sub();
        assertEquals("DEFG", test.verschluesseln(key, "ABCD"));
        assertEquals("BCD", test.verschluesseln(key, "YZA"));
        assertEquals("CGP", test.verschluesseln(key, "ZDM"));
        assertEquals("DEFGHIJKLMNOPQRSTUVWXYZABC",
                test.verschluesseln(key, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

    }
    
    @Test 
    public void testEntschluesseln(){
        Crypter test = new Sub();
        assertEquals("ABCD", test.entschluesseln(key, "DEFG"));
        assertEquals("ZZ BB", test.entschluesseln(key, "CC EE"));
    }
}
