package de.wagnst.tpe.exercise.crypter;

/**
 * Basic class to check a key for encode, decode methods. It checks the length,
 * literals and duplicates
 * 
 * @author Max
 *
 */

public class KeyCorrectness {

    /**
     * checks the length of given key and compares it with minimum/maximum
     * length addicted to the encode/decode method on use
     *
     * @param method to encode/decode
     * @param key to check
     *
     * @throws IllegalKeyException if key is zero or out of range min/max
     */
    public static void checkLength(CrypterVerfahren method, String key)
            throws IllegalKeyException {
        /* set maximum key length on default -1 for XOR */
        if (key.length() >= method.getMinKeyLength()
                && method.getMaxKeyLength() == -1) {
            return;
        } else if (key.length() >= method.getMinKeyLength()
                && key.length() <= method.getMaxKeyLength()) {
            return;
        } else

            throw new IllegalKeyException("we need " + method.getKeyRange()
                    + " @ " + method.getName());
    }

    /**
     * check keys literals and compare it with the alphabet given from the
     * method on use
     *
     * @param method to encode/decode
     * @param key to check
     *
     * @throws IllegalKeyException if at least one literal is not at alphabet
     *         from the method on use
     */
    public static void checkLiterals(CrypterVerfahren method, String key)
            throws IllegalKeyException {
        for (int i = 0; i < key.length(); i++) {
            /* true if index is not at methods alphabet */
            if (!method.getAlphabet().contains(
                    (Character.toString(key.charAt(i))))) {

                if (Character.isDigit(key.charAt(i))) {
                    throw new IllegalKeyException("numbers are not allowed @ "
                            + method.getName());

                } else if (method.getAlphabet().contains(
                        Character.toString(key.charAt(i)).toUpperCase())) {
                    throw new IllegalKeyException("use capital letters @ "
                            + method.getName());

                } else if (Character.isSpaceChar(key.charAt(i))) {
                    throw new IllegalKeyException("spaces are not allowed @ "
                            + method.getName());
                } else {

                    throw new IllegalKeyException(
                            "have a look which special characters are allowed @ "
                                    + method.getName());
                }
            }
        }
    }

    /**
     * checks the key if it contains any duplicates
     *
     * @param method to encode/decode
     * @param key to check
     *
     * @throws IllegalKeyException if duplicates detected
     */

    /* TODO find a way without second for loop */
    public static void checkDuplicates(CrypterVerfahren method, String key)
            throws IllegalKeyException {
        for (int i = 0; i < key.length(); i++) {
            int count = 0;
            for (int j = 0; j < key.length(); j++) {
                if (key.charAt(i) == key.charAt(j)) {
                    count++;
                    if (count > 1) {
                        throw new IllegalKeyException(
                                "duplicates are not allowed @"
                                        + method.getName());
                    }

                }
            }
        }
    }
}
