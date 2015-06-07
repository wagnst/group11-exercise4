package de.wagnst.tpe.exercise.tests;

import de.wagnst.tpe.exercise.crypter.*;
import de.wagnst.tpe.exercise.crypters.CrypterFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCaesarEncode {

    private String key = "A";

    /* encode */
    @Test
    public void encode() throws IllegalKeyException, IllegalMessageException,
            IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        assertEquals("ABCD", test.verschluesseln(key, "ZABC"));
        assertEquals("MNO", test.verschluesseln(key, "LMN"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                test.verschluesseln(key, "ZABCDEFGHIJKLMNOPQRSTUVWXY"));
    }

    /* Key */

    /*
     * KeyExceptions too small/large key
     */

    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException1() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        test.verschluesseln(" ", "HALLO");
    }

    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException2() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        test.verschluesseln("DE", "HALLO");
    }

    /* illegal literals */
    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException3() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        test.verschluesseln("?", "HALLO");
    }

    @Test(expected = IllegalKeyException.class)
    public void IllegalKeyException4() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        test.verschluesseln("a", "HALLO");
    }

    /* Message */

    /* empty message */
    @Test(expected = IllegalMessageException.class)
    public void IllegalMessageException1() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        assertEquals("ABC", test.verschluesseln(key, ""));
    }

    /* wrong literal */
    @Test(expected = IllegalMessageException.class)
    public void IllegalMessageException2() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        assertEquals("ABC", test.verschluesseln(key, "ABC!"));
    }

    @Test(expected = IllegalMessageException.class)
    public void IllegalMessageException3() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {
        Crypter test = CrypterFactory
                .createCrypter(CrypterVerfahren.CAESAR);
        assertEquals("ABC", test.verschluesseln(key, "ABC2"));
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
        assertTrue(text.equals(test.entschluesseln(key,
                test.verschluesseln(key, text))) == true);
    }
}