package de.wagnst.tpe.exercise.subsitutionschiffre;

import org.junit.Test;

import static org.junit.Assert.*;
import de.wagnst.tpe.exercise.crypter.*;

public class TestSub {
    // ABCDEFGHIJKLMNOPQRSTUVWXYZ
    private String key = "DEFGHIJKLMNOPQRSTUVWXYZABC";
    Crypter test = new Sub();

    @Test
    public void testVerschluessln() throws IllegalKeyException,
            IllegalMessageException {

        assertEquals("DEFG", test.verschluesseln(key, "ABCD"));
        assertEquals("BCD", test.verschluesseln(key, "YZA"));
        assertEquals("CGP", test.verschluesseln(key, "ZDM"));
        assertEquals("DEFGHIJKLMNOPQRSTUVWXYZABC",
                test.verschluesseln(key, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

    }

    @Test
    public void testEntschluesseln() throws IllegalKeyException,
            IllegalMessageException {

        assertEquals("ABCD", test.entschluesseln(key, "DEFG"));
        assertEquals("ZZ BB", test.entschluesseln(key, "CC EE"));
    }

    @Test(expected = IllegalMessageException.class)
    public void testIllegalMessageException() {
        new Sub().verschluesseln(key, "A B");
    }

}
