package de.wagnst.tpe.exercise.tests;

import de.wagnst.tpe.exercise.crypter.*;
import de.wagnst.tpe.exercise.crypters.CrypterFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestXOREncode {

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

    /* Test for length of key */
    @Test
    public void IllegalKeyExceptionLength() throws IllegalKeyException,
            IllegalMessageException, IllegalCrypterException {

        Crypter test = CrypterFactory.createCrypter(CrypterVerfahren.XOR);

        /* Empty Key */
        try {
            test.verschluesseln("", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
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
            assertTrue(false);
        } catch (IllegalKeyException e) {
            assertTrue(true);
        }

        /* Non capital letters in key */
        try {
            test.verschluesseln("yOLO", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
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
            assertTrue(false);
        } catch (IllegalMessageException e) {
            assertTrue(true);
        }

        try {
            test.verschluesseln("YOLO", "ABC2");
            assertTrue(false);
        } catch (IllegalMessageException e) {
            assertTrue(true);
        }

        try {
            test.verschluesseln("YOLO", "ABC DE");
            assertTrue(false);
        } catch (IllegalMessageException e) {
            assertTrue(true);
        }

        try {
            test.verschluesseln("YOLO", "aBCdE");
            assertTrue(false);
        } catch (IllegalMessageException e) {
            assertTrue(true);
        }

    }

}