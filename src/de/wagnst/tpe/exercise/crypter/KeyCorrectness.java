package de.wagnst.tpe.exercise.crypter;

public class KeyCorrectness {

    /**
     * checks the length of the key return true if length is correct, else
     * false; throws exception if key is null
     * 
     * @throws IllegalKeyException if key is null
     * @param method of encode/decode
     * @param key to check
     * @return boolean
     */
    public static void checkLength(CrypterVerfahren method, String key)
            throws IllegalKeyException {

        if (key.length() == -1 && key.length() <= method.getMaxKeyLength()) {
            return;
        } else if (key.length() >= method.getMinKeyLength()
                && key.length() <= method.getMaxKeyLength()) {
            return;
        } else
            throw new IllegalKeyException(
                    "key needs to be more than 0 literals");
    }

    public static boolean checkLiterals(CrypterVerfahren method, String key)
            throws IllegalKeyException {

        for (int i = 0; i < key.length(); i++) {
            if (!method.getAlphabet().contains(
                    (Character.toString(key.charAt(i))))) {
                throw new IllegalKeyException("please Only use capital letters");
            }
        }

        return true;
    }

    public static boolean checkDuplicates(CrypterVerfahren method, String key)
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
        return true;
    }

}
