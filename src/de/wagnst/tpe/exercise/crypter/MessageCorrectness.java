package de.wagnst.tpe.exercise.crypter;

public class MessageCorrectness {

    public static final int maxLetter = 100000;

    public static boolean checkLength(CrypterVerfahren method, String message)
            throws IllegalMessageException {
        if (message.length() == 0) {
            throw new IllegalMessageException("atleast insert something @" + method.getName());
        }

        if (message.length() > maxLetter) {
            throw new IllegalMessageException("use less than " + maxLetter
                    + " letters @" + method.getName());
        }

        return true;
    }

    public static boolean checkLiterals(CrypterVerfahren method, String message)
            throws IllegalMessageException {

        if (message.contains(Character.toString(' '))) {
            throw new IllegalMessageException("spaces are not allowed @"
                    + method.getName());
        }

        for (int i = 0; i < message.length(); i++) {
            if (!method.getAlphabet().contains(
                    Character.toString(message.charAt(i)))) {

                /* find small letters at message */
                String tmp = Character.toString(message.charAt(i))
                        .toUpperCase();

                if (method.getAlphabet().contains(tmp)) {
                    throw new IllegalMessageException(
                            "small letters are not allowed @"
                                    + method.getName());
                } else {

                    throw new IllegalMessageException(
                            "some literals doesnt exist @" + method.getName()
                                    + "'s alpabeth");
                }
            }
        }

        return true;
    }

}
