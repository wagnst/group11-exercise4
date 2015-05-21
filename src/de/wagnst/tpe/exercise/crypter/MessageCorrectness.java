package de.wagnst.tpe.exercise.crypter;

public class MessageCorrectness {

    public static final int maxLetter = 100000;

    public static String checkAndFormat(CrypterVerfahren method, String message)
            throws IllegalMessageException {
        if (message.length() == 0) {
            throw new IllegalMessageException("atleast insert something");
        }

        if (message.length() > maxLetter) {
            throw new IllegalMessageException("use less than " + maxLetter
                    + " letters");
        }

        message = message.toUpperCase();
        message = message.replaceAll(" ", "");

        for (int i = 0; i < message.length(); i++) {
            if (!method.getAlphabet().contains(
                    Character.toString(message.charAt(i)))) {
                throw new IllegalMessageException(
                        "some literals doesnt exist at " + method.getName()
                                + "'s alpabeth");
            }
        }
        return message;
    }

}
