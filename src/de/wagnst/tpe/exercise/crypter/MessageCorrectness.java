package de.wagnst.tpe.exercise.crypter;

public class MessageCorrectness {

    public static final int maxLetter = 100000;

    /**
     * method to check the length of given message. Set maxLetter to ensure
     * performance. message with length of zero is always false
     * 
     * @throws IllegalMessageException if message goes against the method
     *         convention
     * @param method method which will be used to encode/decode
     * @param message message to check
     * @return true if the messages length fits the convention of used method
     */
    public static boolean checkLength(CrypterVerfahren method, String message)
            throws IllegalMessageException {
        if (message.length() == 0) {
            throw new IllegalMessageException("atleast insert something @"
                    + method.getName());

        } else if (message.length() > maxLetter) {
            throw new IllegalMessageException("use less than " + maxLetter
                    + " letters @" + method.getName());
        }

        return true;
    }

    /**
     * check message literals and compare it with the alphabet given from the
     * method on use
     * 
     * @param method to encode/decode
     * @param message to check
     * @throws IllegalMessageException if at least one literal is not at
     *         alphabet from the method on use
     * @return true if messages format fits the convention of used method
     */
    public static boolean checkLiterals(CrypterVerfahren method, String message)
            throws IllegalMessageException {

        for (int i = 0; i < message.length(); i++) {
            if (!method.getAlphabet().contains(
                    Character.toString(message.charAt(i)))) {

                if (Character.isDigit(message.charAt(i))) {
                    throw new IllegalMessageException(
                            "numbers are not allowed @ " + method.getName());

                } else if (method.getAlphabet().contains(
                        Character.toString(message.charAt(i)).toUpperCase())) {
                    throw new IllegalMessageException("use capital letters @ "
                            + method.getName());

                } else if (Character.isSpaceChar(message.charAt(i))) {
                    throw new IllegalMessageException(
                            "spaces are not allowed @ " + method.getName());
                } else {

                    throw new IllegalMessageException(
                            "have a look which special characters are allowed @ "
                                    + method.getName());
                }

            }
        }

        return true;
    }

}
