package de.wagnst.tpe.exercise.tests;

import de.wagnst.tpe.exercise.crypter.*;
import de.wagnst.tpe.exercise.crypters.CrypterFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestXOREncode {

    @Test
    public void encode() throws IllegalKeyException, IllegalMessageException,
            IllegalCrypterException {

        Crypter test = CrypterFactory.createCrypter(CrypterVerfahren.XOR);

        //example from github
        assertEquals("URFVPJB[]ZN^XBJCEBVF@ZRKMJ", test.verschluesseln(
                "TPERULES", "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

        //exercise string
        assertEquals("RXZL_FO\\W_UXX_S]KPOVQCTLTQZVG]^L_FXWWIYYVDQD\\PQTQAEXAODQAXZRQBQEA[HLZW",
                test.verschluesseln("WINTERISCOMING", "EQTXZTFOTPXQVXDTEDJDXPWCYXTQPTPXZTQDTFTPXCFMRDTFXRFWLFJVVQTFTPXVBTEETP"));

    }
}