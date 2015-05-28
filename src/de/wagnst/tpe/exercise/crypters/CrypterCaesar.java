package de.wagnst.tpe.exercise.crypters;


import de.wagnst.tpe.exercise.crypter.*;

class CrypterCaesar implements Crypter {


    /**
     * Encode the decoded message with the key.
     *
     * @param key        key, which should be used.
     * @param cypherText message, which should be encoded.
     *
     * @return encoded message.
     *
     * @throws IllegalKeyException     Wird geworfen, wenn der Schlüssel nicht
     *                                 zum Verschlüsselungsverfahren passt
     * @throws IllegalMessageException Wird geworfen, wenn die Nachricht
     *                                  unerlaubte Zeichen enthält.
     */
    @Override
    public String entschluesseln(String key, String cypherText)
            throws IllegalKeyException, IllegalMessageException {

        KeyCorrectness.checkLength(CrypterVerfahren.CAESAR, key);
        KeyCorrectness.checkLiterals(CrypterVerfahren.CAESAR, key);

        MessageCorrectness.checkLength(CrypterVerfahren.CAESAR,
                cypherText);
        MessageCorrectness.checkLiterals(CrypterVerfahren.CAESAR,
                cypherText);

        char keychar = key.charAt(0);
        String transformedMessage = "";

        for (int i = 0; i < cypherText.length(); i++) {
            //wenn Zahl zu klein wird oder Z zu A
            if ((cypherText.charAt(i) - keychar) <= 0) {
                transformedMessage = transformedMessage + CrypterVerfahren.CAESAR.getAlphabet().charAt((cypherText.charAt(i) - keychar + 26) - 1);
            } else
                transformedMessage = transformedMessage + CrypterVerfahren.CAESAR.getAlphabet().charAt(((cypherText.charAt(i) - keychar)) - 1);
        }


        return transformedMessage;
    }

    /**
     * Verschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
     *
     * @param key     Schlüssel, der verwendet werden soll.
     * @param message Nachricht, die Verschlüsselt werden soll.
     *
     * @return verschlüsselter Text.
     *
     * @throws IllegalKeyException     Wird geworfen, wenn der Schlüssel nicht
     *                                 zum Verschlüsselungsverfahren passt
     * @throws IllegalMessageException Wird geworfen, wenn die Nachricht
     *                                 unerlaubte Zeichen enthält.
     */

    @Override
    public String verschluesseln(String key, String message)
            throws IllegalKeyException, IllegalMessageException {

        KeyCorrectness.checkLength(CrypterVerfahren.CAESAR, key);
        KeyCorrectness.checkLiterals(CrypterVerfahren.CAESAR, key);

        MessageCorrectness.checkLength(CrypterVerfahren.CAESAR, message);
        MessageCorrectness
                .checkLiterals(CrypterVerfahren.CAESAR, message);

        char keychar = key.charAt(0);
        String transformedMessage = "";

        for (int i = 0; i < message.length(); i++) {
            // wenn A zu Z
            if ((((message.charAt(i) + keychar) % 26) + 1) >= 26) {
                transformedMessage = transformedMessage + CrypterVerfahren.CAESAR.getAlphabet().charAt(((message.charAt(i) + keychar) % 26) - 26 + 1);

            } else
                transformedMessage = transformedMessage + CrypterVerfahren.CAESAR.getAlphabet().charAt(((message.charAt(i) + keychar) % 26) + 1);
        }

        return transformedMessage;
    }
}
