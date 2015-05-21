package de.wagnst.tpe.exercise.crypter;

import de.wagnst.tpe.exercise.subsitutionschiffre.Substi;

public class CrypterFactory {

    private CrypterFactory() {

    }

    public static Crypter createCrypter(CrypterVerfahren method) {
        switch (method) {
            case SUBSTI:
                return new Substi();
            case CAESAR:
                return null;
            case XOR:
                return null;
            default:
                //Todo: exception schmeissen, wenn hier
                return null;

        }
    }
}
