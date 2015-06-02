package de.wagnst.tpe.exercise.crypters;

import de.wagnst.tpe.exercise.crypter.*;

/**
 * Class to encode and decode a message with a key. Using method of
 * XOR chiffre. Implements Crypter interface.
 *
 * @author wagnst
 * @see <a href="https://github.com/tpe-lecture/group11-exercise4#xor-verschl%C3%BCsselung">GitHub description</a>
 */

class CrypterXOR implements Crypter {

    /**
     * Repeats a String several times
     *
     * @param str   input string that should be repeated
     * @param times how many times to repeat
     * @return repeated string
     */
    private static String repeat(String str, int times) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < times; i++) ret.append(str);
        return ret.toString();
    }

    /**
     * Encrypts text with a given key
     *
     * @param key     key, which should be used
     * @param message message, that should be encrypted
     * @return encrypted text
     * @throws IllegalKeyException     thrown if key does not match crypter
     * @throws IllegalMessageException thrown if message contains not allowed
     *                                 signs
     * @see de.wagnst.tpe.exercise.crypter
     */

    @Override
    public String verschluesseln(String key, String message)
            throws IllegalKeyException, IllegalMessageException {

        int xor;
        char temp;
        String filledKey = "";
        String transformedMessage = "";

        /* Check key for correctness */
        KeyCorrectness.checkLength(CrypterVerfahren.XOR, key);
        KeyCorrectness.checkLiterals(CrypterVerfahren.XOR, key);

        /* Check the message correctness */
        MessageCorrectness.checkLength(CrypterVerfahren.XOR, message);
        MessageCorrectness.checkLiterals(CrypterVerfahren.XOR, message);

        /* fill key to size of message */
        if (key.length() != message.length()) {
            filledKey = repeat(key, (message.length() / key.length()));
        }

        for (int i = 0; i < message.length(); i++) {
            xor = message.charAt(i) ^ filledKey.charAt(i);
            temp = (char) xor;
            transformedMessage += CrypterVerfahren.XOR.getAlphabet().charAt(temp);
        }

        return transformedMessage;
    }

    /**
     * Decrypts text with a given key
     *
     * @param key        key, which should be used
     * @param cypherText message, that should be decrypted
     * @return decrypted text
     * @throws IllegalKeyException     thrown if key does not match crypter
     * @throws IllegalMessageException thrown if message contains not allowed
     *                                 signs
     * @see de.wagnst.tpe.exercise.crypter
     */

    @Override
    public String entschluesseln(String key, String cypherText)
            throws IllegalKeyException, IllegalMessageException {

        int xor;
        char temp;
        String filledKey = "";
        String transformedMessage = "";

        /* Check key for correctness */
        KeyCorrectness.checkLength(CrypterVerfahren.XOR, key);
        KeyCorrectness.checkLiterals(CrypterVerfahren.XOR, key);

        /* Check the message correctness */
        MessageCorrectness.checkLength(CrypterVerfahren.XOR, cypherText);
        MessageCorrectness.checkLiterals(CrypterVerfahren.XOR, cypherText);

        /* fill key to size of message */
        if (key.length() != cypherText.length()) {
            filledKey = repeat(key, (cypherText.length() / key.length()));
        }

        for (int i = 0; i < cypherText.length(); i++) {
            xor = cypherText.charAt(i) ^ filledKey.charAt(i);
            temp = (char) xor;
            transformedMessage += CrypterVerfahren.XOR.getAlphabet().charAt(temp);
        }

        return transformedMessage;
    }
}
