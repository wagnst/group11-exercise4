package de.wagnst.tpe.exercise.subsitutionschiffre;

import de.wagnst.tpe.exercise.crypter.IllegalKeyException;
import de.wagnst.tpe.exercise.crypter.*;

public class KeyCorrectness {

    public static boolean KeyCorrectnes(String key) throws IllegalKeyException,
            IllegalMessageException {

        checkLength(key);
        return true;
    }

    private static void checkLength(String key) throws IllegalKeyException {
        if (key.length() != 26) {
            throw new IllegalKeyException(
                    "please insert a key within 26 letters");
        }
    }
}
