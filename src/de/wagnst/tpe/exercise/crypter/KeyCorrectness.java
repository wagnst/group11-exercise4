package de.wagnst.tpe.exercise.crypter;

public class KeyCorrectness {

    /**
     * checks the length of given key and compares it with minimum/maximum
     * length addicted to the encode/decode method on use
     * 
     * 
     * @param method to encode/decode
     * @param key to check
     * @throws IllegalKeyException if key is null or out of range min/max
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

            /* TODO message fixen */
            throw new IllegalKeyException("we need " + method.getKeyRange());
    }

    /**
     * checks keys literals and compares it with the alphabet given from the
     * encode/decode method on use
     * 
     * @param method to encode/decode
     * @param key to check
     * @throws IllegalKeyException if at least one literal is not at alphabet
     *         from the method on use
     * */
    public static void checkLiterals(CrypterVerfahren method, String key)
            throws IllegalKeyException {
        /*
         * TODO is any method interested in small and capital letters? --> else
         * do toUpperCase
         */
        for (int i = 0; i < key.length(); i++) {
            if (!method.getAlphabet().contains(
                    (Character.toString(key.charAt(i))))) {
                throw new IllegalKeyException("check the alphabet of "
                        + method.getName());
            }
        }
    }

    /**
     * checks the key if it contains any duplicates
     * 
     * @param method to encode/decode
     * @param key to check
     * @throws IllegalKeyException if duplicates detected
     * 
     * */
    public static void checkDuplicates(CrypterVerfahren method, String key)
            throws IllegalKeyException {
        for (int i = 0; i < key.length(); i++) {
            int count = 0;
            for (int j = 0; j < key.length(); j++) {
                if (key.charAt(i) == key.charAt(j)) {
                    count++;
                    if (count > 1) {
                        throw new IllegalKeyException(
                                "duplicates are not allowed");
                    }

                }
            }
        }
    }
}
