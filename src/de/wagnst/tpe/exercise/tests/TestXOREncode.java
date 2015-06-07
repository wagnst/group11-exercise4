package de.wagnst.tpe.exercise.tests;

import de.wagnst.tpe.exercise.crypter.*;
import de.wagnst.tpe.exercise.crypters.CrypterFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestXOREncode {

    private String key = "TPERULES";

    @Test
    public void encode() throws IllegalKeyException, IllegalMessageException,
            IllegalCrypterException {

        Crypter test = CrypterFactory.createCrypter(CrypterVerfahren.XOR);

        assertEquals("URFVPJB[]ZN^XBJCEBVF@ZRKMJ", test.verschluesseln(key,
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }
}