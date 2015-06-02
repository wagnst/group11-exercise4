package de.wagnst.tpe.exercise.crypters;

import de.wagnst.tpe.exercise.crypter.Crypter;
import de.wagnst.tpe.exercise.crypter.IllegalKeyException;
import de.wagnst.tpe.exercise.crypter.IllegalMessageException;

/**
 * Class to encode and decode a message with a key. Using method of
 * A UNKNOWN chiffre. Implements Crypter interface.
 *
 * @author wagnst
 * @see <a href="https://github.com/tpe-lecture/group11-exercise4#">GitHub description</a>
 */
class CrypterNEW_CIPHER implements Crypter {

    /**
     * Decode the encoded message with the key.
     *
     * @param key     key, which should be used.
     * @param message message, which should be encoded.
     * @return decoded message.
     * @throws IllegalKeyException     will throw, if the key doesn't fit to
     *                                 the ciphering method.
     * @throws IllegalMessageException will throw, if the message has forbidden
     *                                 signs.
     */
    @Override
    public String verschluesseln(String key, String message) throws IllegalKeyException, IllegalMessageException {
        return null;
    }

    /**
     * Encode the decoded message with the key.
     *
     * @param key        key, which should be used.
     * @param cypherText message, which should be encoded.
     * @return decoded message.
     * @throws IllegalKeyException     will throw, if the key doesn't fit to
     *                                 the ciphering method.
     * @throws IllegalMessageException will throw, if the message has forbidden
     *                                 signs.
     */
    @Override
    public String entschluesseln(String key, String cypherText) throws IllegalKeyException, IllegalMessageException {
        return null;
    }
}
