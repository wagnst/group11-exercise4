package de.wagnst.tpe.exercise.crypter;

public class MessageCorrectness {

    public static final int maxLetter = 100000;

    public static String checkAndFormat(CrypterVerfahren method, String message)
            throws IllegalMessageException {
        if (message.length() > maxLetter) {
            throw new IllegalMessageException("use less than " + maxLetter
                    + " letters");
        }

        message = message.toUpperCase();
        message = message.replaceAll(" ", "");

        /* TODO check for illegal literals at message */
    }
}
