package de.wagnst.tpe.exercise.xorcrypt;

import de.wagnst.tpe.exercise.crypter.Crypter;
import de.wagnst.tpe.exercise.crypter.IllegalKeyException;
import de.wagnst.tpe.exercise.crypter.IllegalMessageException;

/**
 * Copyright by Steffen Wagner (D059727)
 *
 * Created on 21.05.2015, 12:13 Project: group11-exercise4
 */

public class CrypterXOR implements Crypter {

    /**
     * @see de.wagnst.tpe.exercise.crypter
     */
    @Override
    public String verschluesseln(String key, String message)
            throws IllegalKeyException, IllegalMessageException {
        return null;
    }

    /**
     * @see de.wagnst.tpe.exercise.crypter
     */
    @Override
    public String entschluesseln(String key, String cypherText)
            throws IllegalKeyException, IllegalMessageException {
        return null;
    }
}
