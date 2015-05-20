package de.wagnst.tpe.exercise.subsitutionschiffre;

import org.junit.Test;

import static org.junit.Assert.*;
import de.wagnst.tpe.exercise.crypter.*;

public class TestSub {
    // ABCDEFGHIJKLMNOPQRSTUVWXYZ

    private String key = "DEFGHIJKLMNOPQRSTUVWXYZABC";

    /* TODO key mit doppelten Zeichen; */

    Crypter test = new Substi();

    /* encode */
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
    public void removeSpacesAndSmallLetters() throws IllegalKeyException,
    IllegalMessageException {
        
        assertEquals("DEFG", test.verschluesseln(key, "AB CD"));
        assertEquals("BCD", test.verschluesseln(key, "yza"));
    }
    
    
    /*
     * KeyExceptions too small/large key
     */

    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException1() throws IllegalKeyException,
            IllegalMessageException {

        test.verschluesseln("DE", "HALLO");
    }

    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException2() throws IllegalKeyException,
            IllegalMessageException {

        test.verschluesseln("DEFGHIJKLMNOPQRSTUVWXYZABCX", "HALLO");
    }

    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException5() throws IllegalKeyException,
            IllegalMessageException {

        test.verschluesseln("DEFGHIJKLMNOPQRSTUVWXYZAB", "HALLO");
    }

    /* illegal literals */
    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException3() throws IllegalKeyException,
            IllegalMessageException {

        test.verschluesseln("?", "HALLO");
    }

    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException4() throws IllegalKeyException,
            IllegalMessageException {

        test.verschluesseln("a", "HALLO");
    }

    /* duplicates */
    /* begin */
    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException6() throws IllegalKeyException,
            IllegalMessageException {

        test.verschluesseln("DDEFGHIJKLMNOPQRSTUVWXYZABC", "HALLO");
    }

    /* middle */
    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException7() throws IllegalKeyException,
            IllegalMessageException {

        test.verschluesseln("DEFGHIJKLMMOPQRSTUVWXYZABC", "HALLO");
    }

    /* end */
    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException8() throws IllegalKeyException,
            IllegalMessageException {

        test.verschluesseln("DEFGHIJKLMNOPQRSTUVWXYZACC", "HALLO");
    }

    /* MessageExceptions */

    /* decode */
    @Test
    public void testEntschluesseln() throws IllegalKeyException,
            IllegalMessageException {

        assertEquals("ABCD", test.entschluesseln(key, "DEFG"));
        assertEquals("ZZ BB", test.entschluesseln(key, "CC EE"));
    }

}
