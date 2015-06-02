package de.wagnst.tpe.exercise.crypters;

import de.wagnst.tpe.exercise.crypter.Crypter;
import de.wagnst.tpe.exercise.crypter.CrypterVerfahren;
import de.wagnst.tpe.exercise.crypter.IllegalCrypterException;

/**
 * Factory class to create a coder with implemented methods: Caesar,
 * Substitution and XOR. Its the only class which has access to coding methods.
 *
 * @author Max
 */
public class CrypterFactory {

    private CrypterFactory() {

    }

    /**
     * The method
     * {@link #createCrypter(de.wagnst.tpe.exercise.crypter.CrypterVerfahren)}
     * can instantiate new crypther instances depending on the wished method
     *
     * @param method type of crypter method which should be used
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
