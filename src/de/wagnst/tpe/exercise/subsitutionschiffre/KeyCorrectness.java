package de.wagnst.tpe.exercise.subsitutionschiffre;

import de.wagnst.tpe.exercise.crypter.IllegalKeyException;

/**
 * KeyCorrectness checks a key if it is in right format for Substi encoding
 */

public class KeyCorrectness {

    /**
     * checks if the key is at right format: no duplicates , 26 letters, no
     * special literal
     *
     * @param key       which is proved
     * @param cleartext which is used to do encoding
     * @return returns true if key is legal, else false
     * @throws IllegalKeyException is thrown if key is in wrong format
     */
    public static boolean keyIsCorrect(String key, String cleartext)
            throws IllegalKeyException {

        legalLeterals(key, cleartext);
        checkLength(key, cleartext);
        noDublicates(key);

        return true;
    }

    /*TODO shell we do this or can we say: we are only interested in keys within 26 letters?!*/
    private static void checkLength(String key, String cleartext)
            throws IllegalKeyException {

        if (key.length() != 26) {
            throw new IllegalKeyException(
                    "please insert a key within 26 letters");
        }
        
        /*
        if (key.length() == 26) {
            return;
        } else if (key.length() > 26) {
            throw new IllegalKeyException(
                    "please insert a key within 26 letters");
        } else {
            /*
             * TODO count letters, "fill" key with xy method (no duplicates)"
             * build second String key2; then do key+key2
             * if(!cleartext.contains((Character.toString(key.charAt(i))))){
             * key2 += this Character halt ;) }
             */

            /* "fill" at next position of the key */

        // }
    }

    private static void legalLeterals(String key, String cleartext)
            throws IllegalKeyException {
        for (int i = 0; i < key.length(); i++) {
            if (!cleartext.contains((Character.toString(key.charAt(i))))) {
                throw new IllegalKeyException(
                        "please Only use capital letters for your key");
            }
        }
    }

    private static void noDublicates(String key) throws IllegalKeyException {
        for (int i = 0; i < key.length(); i++) {
            int count = 0;
            for (int j = 0; j < key.length(); j++) {
                if (key.charAt(i) == key.charAt(j)) {
                    count++;
                    if (count > 1) {
                        throw new IllegalKeyException(
                                "duplicates are not allowed at key");
                    }

                }
            }
        }

    }
}
