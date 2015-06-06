package de.wagnst.tpe.exercise.tests;

import de.wagnst.tpe.exercise.crypter.*;
import de.wagnst.tpe.exercise.crypters.CrypterFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Copyright by Katharina Spinner (katharinaspinner)
 * <p/>
 * Created on 06.06.15, 16:48 Project: Exercise4
 */
public class TestCaesarDecode {

    private String key = "A";

    /* decode */
    @Test
    public void encode() throws IllegalKeyException, IllegalMessageException,
            IllegalCrypterException {

        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);

        assertEquals("ZABC", test.entschluesseln(key, "ABCD"));
        assertEquals("YZA", test.entschluesseln(key, "ZAB"));
        assertEquals("ZDM", test.entschluesseln(key, "AEN"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                test.entschluesseln(key, "BCDEFGHIJKLMNOPQRSTUVWXYZA"));

    }

     /* KEY */

    /*
     * KeyExceptions too small/large key
     */

    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException1() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        test.entschluesseln(" ", "HALLO");
    }

    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException2() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        test.entschluesseln("DEFGHIJKLMNOPQXYZABCX", "HALLO");
    }

    /* illegal literals */
    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException3() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        test.entschluesseln("?", "HALLO");
    }

    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException4() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        test.entschluesseln("a", "HALLO");
    }


    /* MESSAGE */

    /* empty message */
    @Test(expected = IllegalMessageException.class)
    public void IllegalMessageException1() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        assertEquals("ABC", test.entschluesseln(key, ""));
    }

    /* wrong literal */
    @Test(expected = IllegalMessageException.class)
    public void IllegalMessageException2() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        assertEquals("ABC", test.entschluesseln(key, "ABC!"));
    }

    @Test(expected = IllegalMessageException.class)
    public void IllegalMessageException3() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        assertEquals("ABC", test.entschluesseln(key, "AB2C"));
    }

    @Test(expected = IllegalMessageException.class)
    public void IllegalMessageException4() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        assertEquals("ABC", test.verschluesseln(key, "ABC DE"));
    }

    @Test(expected = IllegalMessageException.class)
    public void IllegalMessageException5() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        assertEquals("ABC", test.verschluesseln(key, "aBCdE"));
    }

    @Test
    public void enDecode() throws IllegalKeyException, IllegalMessageException,
            IllegalCrypterException {
        String text = "HALLO";
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        assertTrue(text.equals(test.verschluesseln(key,
                test.entschluesseln(key, text))) == true);
    }
}