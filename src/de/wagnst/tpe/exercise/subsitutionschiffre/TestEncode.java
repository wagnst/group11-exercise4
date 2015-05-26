package de.wagnst.tpe.exercise.subsitutionschiffre;

import de.wagnst.tpe.exercise.crypter.Crypter;
import de.wagnst.tpe.exercise.crypter.IllegalKeyException;
import de.wagnst.tpe.exercise.crypter.IllegalMessageException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestEncode {

    private String key = "DEFGHIJKLMNOPQRSTUVWXYZABC";

    Crypter test = new CrypterSubstitution();

    /* encode */
    @Test
    public void encode() throws IllegalKeyException, IllegalMessageException {

        assertEquals("DEFG", test.verschluesseln(key, "ABCD"));
        assertEquals("BCD", test.verschluesseln(key, "YZA"));
        assertEquals("CGP", test.verschluesseln(key, "ZDM"));
        assertEquals("DEFGHIJKLMNOPQRSTUVWXYZABC",
                test.verschluesseln(key, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    /* Key */

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

    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException9() throws IllegalKeyException,
            IllegalMessageException {

        test.verschluesseln("DEFGHIJKLMNOPQRS TUVWXYZABC", "HALLO");
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

        test.verschluesseln("DEFGHIJKLMNOPQRSTUVWXYZABD", "HALLO");
    }

    /* end */
    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException8() throws IllegalKeyException,
            IllegalMessageException {

        test.verschluesseln("DEFGHIJKLMNOPQRSTUVWXYZACC", "HALLO");
    }

    /* Message */

    /* empty message */
    @Test(expected = IllegalMessageException.class)
    public void IllegalMessageException1() throws IllegalKeyException,
            IllegalMessageException {
        assertEquals("ABC", test.verschluesseln(key, ""));
    }

    /* wrong literal */
    @Test(expected = IllegalMessageException.class)
    public void IllegalMessageException2() throws IllegalKeyException,
            IllegalMessageException {
        assertEquals("ABC", test.verschluesseln(key, "ABC!"));
    }

    @Test(expected = IllegalMessageException.class)
    public void IllegalMessageException3() throws IllegalKeyException,
            IllegalMessageException {
        assertEquals("ABC", test.verschluesseln(key, "ABC2"));
    }

    @Test
    public void enDecode() throws IllegalKeyException, IllegalMessageException {
        String text = "HALLO";

        assertTrue(text.equals(test.entschluesseln(key,
                test.verschluesseln(key, text))) == true);
    }
}
