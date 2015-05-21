package de.wagnst.tpe.exercise.crypter;

import de.wagnst.tpe.exercise.subsitutionschiffre.CrypterSubstitution;
import de.wagnst.tpe.exercise.xorcrypt.CrypterXOR;

public class CrypterFactory {

    private CrypterFactory() {

    }

    /**
     * The method {@link #createCrypter(CrypterVerfahren)} can instantiate new
     * crypther instances depending on the wished method
     *
     * @param method type of crypter method which should be used
     *
     * @return instance of encryption type
     */
    public static Crypter createCrypter(CrypterVerfahren method)
            throws IllegalCrypterException {
        switch (method) {
            case SUBSTITUTION:
                return new CrypterSubstitution();
            case CAESAR:
                return new CrypterCaesar();
            case XOR:
                return new CrypterXOR();
            default:
                throw new IllegalCrypterException("no valid crypter method used");

        }
    }
}
