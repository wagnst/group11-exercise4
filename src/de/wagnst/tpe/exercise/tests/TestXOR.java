package de.wagnst.tpe.exercise.tests;

import de.wagnst.tpe.exercise.crypter.*;
import de.wagnst.tpe.exercise.crypters.CrypterFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestXOR {

    @Test
    public void encode() throws IllegalKeyException, IllegalMessageException,
            IllegalCrypterException {

        Crypter test = CrypterFactory.createCrypter(CrypterVerfahren.XOR);

        //example from github
        assertEquals("URFVPJB[]ZN^XBJCEBVF@ZRKMJ", test.verschluesseln(
                "TPERULES", "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

        //string from exercise
        assertEquals("RXZL_FO\\W_UXX_S]KPOVQCTLTQZVG]^L_FXWWIYYVDQD\\PQTQAEXAODQAXZRQBQEA[HLZW",
                test.verschluesseln("WINTERISCOMING", "EQTXZTFOTPXQVXDTEDJDXPWCYXTQPTPXZTQDTFTPXCFMRDTFXRFWLFJVVQTFTPXVBTEETP"));

    }

    @Test
    public void decode() throws IllegalKeyException, IllegalMessageException,
            IllegalCrypterException {

        Crypter test = CrypterFactory.createCrypter(CrypterVerfahren.XOR);

        //example from github
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", test.entschluesseln(
                "TPERULES", "URFVPJB[]ZN^XBJCEBVF@ZRKMJ"));

        //string from exercise
        assertEquals("EQTXZTFOTPXQVXDTEDJDXPWCYXTQPTPXZTQDTFTPXCFMRDTFXRFWLFJVVQTFTPXVBTEETP",
                test.entschluesseln("WINTERISCOMING", "RXZL_FO\\W_UXX_S]KPOVQCTLTQZVG]^L_FXWWIYYVDQD\\PQTQAEXAODQAXZRQBQEA[HLZW"));
    }

    /* Test for length of key */
    @Test
    public void IllegalKeyExceptionLength() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {

        Crypter test = CrypterFactory.createCrypter(CrypterVerfahren.XOR);

        /* Empty Key */
        try {
            test.verschluesseln("", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            test.entschluesseln("", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            assertTrue(false);
        } catch (IllegalKeyException e) {
            assertTrue(true);
        }

    }

    /* Test for literals in key */
    @Test
    public void IllegalKeyExceptionLiterals() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {

        Crypter test = CrypterFactory.createCrypter(CrypterVerfahren.XOR);

        /* Invalid signs in key */
        try {
            test.verschluesseln("YOLO!", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            test.entschluesseln("YOLO!", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            assertTrue(false);
        } catch (IllegalKeyException e) {
            assertTrue(true);
        }

        /* Non capital letters in key */
        try {
            test.verschluesseln("yOLO", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            test.entschluesseln("yOLO", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            assertTrue(false);
        } catch (IllegalKeyException e) {
            assertTrue(true);
        }

    }

    /* Test for length of message */
    @Test
    public void IllegalMessageExceptionLength() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {

        Crypter test = CrypterFactory.createCrypter(CrypterVerfahren.XOR);

        /* Empty message */
        try {
            test.verschluesseln("YOLO", "");
            test.entschluesseln("YOLO", "");
            assertTrue(false);
        } catch (IllegalMessageException e) {
            assertTrue(true);
        }

    }

    /* Test for literals in message */
    @Test
    public void IllegalMessageExceptionLiterals() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {

        Crypter test = CrypterFactory.createCrypter(CrypterVerfahren.XOR);

        try {
            test.verschluesseln("YOLO", "ABC!");
            test.entschluesseln("YOLO", "ABC!");
            assertTrue(false);
        } catch (IllegalMessageException e) {
            assertTrue(true);
        }

        try {
            test.verschluesseln("YOLO", "ABC2");
            test.entschluesseln("YOLO", "ABC2");
            assertTrue(false);
        } catch (IllegalMessageException e) {
            assertTrue(true);
        }

        try {
            test.verschluesseln("YOLO", "ABC DE");
            test.entschluesseln("YOLO", "ABC DE");
            assertTrue(false);
        } catch (IllegalMessageException e) {
            assertTrue(true);
        }

        try {
            test.verschluesseln("YOLO", "aBCdE");
            test.entschluesseln("YOLO", "aBCdE");
            assertTrue(false);
        } catch (IllegalMessageException e) {
            assertTrue(true);
        }

    }

}