package de.wagnst.tpe.exercise.crypters;

import de.wagnst.tpe.exercise.crypter.*;

/**
 * Class to encode and decode a message with a key. Using method of
 * Caesar chiffre. Implements Crypter interface.
 *
 * @author Rahtainka
 * @see <a href="https://github.com/tpe-lecture/group11-exercise4#caesar-verschl%C3%BCsselung">GitHub description</a>
 */

class CrypterCaesar implements Crypter {


    /**
     * Decode the encoded message with the key.
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
    public String entschluesseln(String key, String cypherText)
            throws IllegalKeyException, IllegalMessageException {

        KeyCorrectness.checkLength(CrypterVerfahren.CAESAR, key);
        KeyCorrectness.checkLiterals(CrypterVerfahren.CAESAR, key);

        MessageCorrectness.checkLength(CrypterVerfahren.CAESAR,
                cypherText);
        MessageCorrectness.checkLiterals(CrypterVerfahren.CAESAR,
                cypherText);

        char keychar = key.charAt(0);
        String transformedMessage = "";

        for (int i = 0; i < cypherText.length(); i++) {
            //if number to small or Z to A
            if ((cypherText.charAt(i) - keychar) <= 0) {
                transformedMessage = transformedMessage + CrypterVerfahren.CAESAR.getAlphabet().charAt((cypherText.charAt(i) - keychar + 26) - 1);
            } else
                transformedMessage = transformedMessage + CrypterVerfahren.CAESAR.getAlphabet().charAt(((cypherText.charAt(i) - keychar)) - 1);
        }


        return transformedMessage;
    }

    /**
     * Encode the decoded message with the key.
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
    public String verschluesseln(String key, String message)
            throws IllegalKeyException, IllegalMessageException {

        KeyCorrectness.checkLength(CrypterVerfahren.CAESAR, key);
        KeyCorrectness.checkLiterals(CrypterVerfahren.CAESAR, key);

        MessageCorrectness.checkLength(CrypterVerfahren.CAESAR, message);
        MessageCorrectness
                .checkLiterals(CrypterVerfahren.CAESAR, message);

        char keychar = key.charAt(0);
        String transformedMessage = "";

        for (int i = 0; i < message.length(); i++) {
            // if A to Z
            if ((((message.charAt(i) + keychar) % 26) + 1) >= 26) {
                transformedMessage = transformedMessage + CrypterVerfahren.CAESAR.getAlphabet().charAt(((message.charAt(i) + keychar) % 26) - 26 + 1);

            } else
                transformedMessage = transformedMessage + CrypterVerfahren.CAESAR.getAlphabet().charAt(((message.charAt(i) + keychar) % 26) + 1);
        }

        return transformedMessage;
    }
}
