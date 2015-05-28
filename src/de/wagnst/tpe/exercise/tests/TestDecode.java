package de.wagnst.tpe.exercise.tests;

import de.wagnst.tpe.exercise.crypter.Crypter;
import de.wagnst.tpe.exercise.crypter.IllegalKeyException;
import de.wagnst.tpe.exercise.crypter.IllegalMessageException;
import de.wagnst.tpe.exercise.crypters.CrypterSubstitution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDecode {

    private String key = "DEFGHIJKLMNOPQRSTUVWXYZABC";

    Crypter test = new CrypterSubstitution();

    /* decode */
    @Test
    public void encode() throws IllegalKeyException, IllegalMessageException {

        assertEquals("ABCD", test.entschluesseln(key, "DEFG"));
        assertEquals("YZA", test.entschluesseln(key, "BCD"));
        assertEquals("ZDM", test.entschluesseln(key, "CGP"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                test.entschluesseln(key, "DEFGHIJKLMNOPQRSTUVWXYZABC"));
    }

    /* KEY */

    /*
     * KeyExceptions too small/large key
     */

    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException1() throws IllegalKeyException,
            IllegalMessageException {

        test.entschluesseln("DE", "HALLO");
    }

    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException2() throws IllegalKeyException,
            IllegalMessageException {

        test.entschluesseln("DEFGHIJKLMNOPQRSTUVWXYZABCX", "HALLO");
    }

    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException5() throws IllegalKeyException,
            IllegalMessageException {

        test.entschluesseln("DEFGHIJKLMNOPQRSTUVWXYZAB", "HALLO");
    }

    /* illegal literals */
    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException3() throws IllegalKeyException,
            IllegalMessageException {

        test.entschluesseln("?", "HALLO");
    }

    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException4() throws IllegalKeyException,
            IllegalMessageException {

        test.entschluesseln("a", "HALLO");
    }

    /* duplicates */
    /* begin */
    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException6() throws IllegalKeyException,
            IllegalMessageException {

        test.entschluesseln("DDEFGHIJKLMNOPQRSTUVWXYZABC", "HALLO");
    }

    /* middle */
    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException7() throws IllegalKeyException,
            IllegalMessageException {

        test.entschluesseln("DEFGHIJKLMNOPQRSTUVWXYZABD", "HALLO");
    }

    /* end */
    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException8() throws IllegalKeyException,
            IllegalMessageException {

        test.entschluesseln("DEFGHIJKLMNOPQRSTUVWXYZACC", "HALLO");
    }

    /* MESSAGE */

    /* empty message */
    @Test(expected = IllegalMessageException.class)
    public void IllegalMessageException1() throws IllegalKeyException,
            IllegalMessageException {
        assertEquals("ABC", test.entschluesseln(key, ""));
    }

    /* wrong literal */
    @Test(expected = IllegalMessageException.class)
    public void IllegalMessageException2() throws IllegalKeyException,
            IllegalMessageException {
        assertEquals("ABC", test.entschluesseln(key, "ABC!"));
    }

    @Test(expected = IllegalMessageException.class)
    public void IllegalMessageException3() throws IllegalKeyException,
            IllegalMessageException {
        assertEquals("ABC", test.entschluesseln(key, "AB2C"));
    }

    @Test
    public void enDecode() throws IllegalKeyException, IllegalMessageException {
        String text = "HALLO";

        assertTrue(text.equals(test.verschluesseln(key,
                test.entschluesseln(key, text))) == true);
    }
}