package de.wagnst.tpe.exercise.crypters;

import de.wagnst.tpe.exercise.crypter.*;

/**
 * Class to encode and decode a message with a key. Using method of substitution
 * chiffre. Implements Crypter interface.
 *
 * @author Max
 * @see <a
 *      href="https://github.com/tpe-lecture/group11-exercise4#subsitutionschiffre">GitHub
 *      description</a>
 */
class CrypterSubstitution implements Crypter {

    /**
     * Encode a message with a given key.
     *
     * @param key to encode the message
     * @param message which will be encoded
     * @return encode message String
     * @throws IllegalKeyException will be thrown if the key doesn't fit to the
     *         ciphering method.
     * @throws IllegalMessageException will be thrown if the message has
     *         forbidden signs.
     */
    @Override
    public String verschluesseln(String key, String message)
            throws IllegalKeyException, IllegalMessageException {

        String transformedMessage = "";

        KeyCorrectness.checkLength(CrypterVerfahren.SUBSTITUTION, key);
        KeyCorrectness.checkLiterals(CrypterVerfahren.SUBSTITUTION, key);
        KeyCorrectness.checkDuplicates(CrypterVerfahren.SUBSTITUTION, key);

        MessageCorrectness.checkLength(CrypterVerfahren.SUBSTITUTION, message);
        MessageCorrectness
                .checkLiterals(CrypterVerfahren.SUBSTITUTION, message);

        /* select the letter to encode */
        int pointer = 0;
        for (int i = 0; i < message.length(); i++) {
            /* find chars position at the alphabet */
            int j = 0;
            while (message.charAt(pointer) != (CrypterVerfahren.SUBSTITUTION
                    .getAlphabet().charAt(j))) {
                j++;
            }
            /*
             * take that char from alphabet which is at the same position like
             * our pointer
             */
            transformedMessage += key.charAt(j);
            pointer++;
        }
        return transformedMessage;
    }

    /**
     * Encode a decoded message with the key.
     *
     * @param key which should be used
     * @param message which should be encoded
     * @return decoded message
     * @throws IllegalKeyException will be thrown if the key doesn't fit to the
     *         ciphering method
     * @throws IllegalMessageException will be thrown if the message has
     *         forbidden signs
     */
    @Override
    public String entschluesseln(String key, String cypherText)
            throws IllegalKeyException, IllegalMessageException {

        String transformedMessage = "";
        int pointer = 0;

        KeyCorrectness.checkLength(CrypterVerfahren.SUBSTITUTION, key);
        KeyCorrectness.checkLiterals(CrypterVerfahren.SUBSTITUTION, key);
        KeyCorrectness.checkDuplicates(CrypterVerfahren.SUBSTITUTION, key);

        MessageCorrectness.checkLength(CrypterVerfahren.SUBSTITUTION,
                cypherText);
        MessageCorrectness.checkLiterals(CrypterVerfahren.SUBSTITUTION,
                cypherText);

        for (int i = 0; i < cypherText.length(); i++) {
            int j = 0;

            while (cypherText.charAt(pointer) != (key.charAt(j))) {
                j++;

            }
            /*
             * take that char from alphabet which is at the same position like
             * our pointer
             */
            transformedMessage += CrypterVerfahren.SUBSTITUTION.getAlphabet()
                    .charAt(j);
            pointer++;

        }
        return transformedMessage;
    }
}
