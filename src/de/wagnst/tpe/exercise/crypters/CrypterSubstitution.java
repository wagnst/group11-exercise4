package de.wagnst.tpe.exercise.crypters;

import de.wagnst.tpe.exercise.crypter.*;

/**
 * Class to encode and decode a message with a key. Using method of
 * Substitutionsschiffre. Implements Crypter interface.
 * 
 * @author Max
 *
 */
class CrypterSubstitution implements Crypter {

    /**
     * Verschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
     *
     * @param key Schlüssel, der verwendet werden soll.
     * @param message Nachricht, die Verschlüsselt werden soll.
     *
     * @return verschlüsselter Text.
     *
     * @throws IllegalKeyException Wird geworfen, wenn der Schlüssel nicht zum
     *         Verschlüsselungsverfahren passt
     * @throws IllegalMessageException Wird geworfen, wenn die Nachricht
     *         unerlaubte Zeichen enthält.
     */
    @Override
    public String verschluesseln(String key, String message)
            throws IllegalKeyException, IllegalMessageException {

        KeyCorrectness.checkLength(CrypterVerfahren.SUBSTITUTION, key);
        KeyCorrectness.checkLiterals(CrypterVerfahren.SUBSTITUTION, key);
        KeyCorrectness.checkDuplicates(CrypterVerfahren.SUBSTITUTION, key);

        MessageCorrectness.checkLength(CrypterVerfahren.SUBSTITUTION, message);
        MessageCorrectness
                .checkLiterals(CrypterVerfahren.SUBSTITUTION, message);

        String transformedMessage = "";
        /* select the letter to encode */
        int pointer = 0;
        for (int i = 0; i < message.length(); i++) {
            /* find chars position at the alphabet */
            int j = 0;
            while (message.charAt(pointer) != (CrypterVerfahren.SUBSTITUTION
                    .getAlphabet().charAt(j))) {
                j++;
            }
            /*
             * catch the char at key which is at the same position asfound at
             * the original alphabet
             */
            transformedMessage += key.charAt(j);
            pointer++;
        }
        return transformedMessage;
    }

    /**
     * Entschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
     *
     * @param key Schlüssel, der verwendet werden soll.
     * @param cypherText Nachricht, die entschlüsselt werden soll.
     *
     * @return entschlüsselter Text.
     *
     * @throws IllegalKeyException Wird geworfen, wenn der Schlüssel nicht zum
     *         Verschlüsselungsverfahren passt
     * @throws IllegalMessageException Wird geworfen, wenn die Nachricht
     *         unerlaubte Zeichen enthält.
     */
    @Override
    public String entschluesseln(String key, String cypherText)
            throws IllegalKeyException, IllegalMessageException {

        KeyCorrectness.checkLength(CrypterVerfahren.SUBSTITUTION, key);
        KeyCorrectness.checkLiterals(CrypterVerfahren.SUBSTITUTION, key);
        KeyCorrectness.checkDuplicates(CrypterVerfahren.SUBSTITUTION, key);

        MessageCorrectness.checkLength(CrypterVerfahren.SUBSTITUTION,
                cypherText);
        MessageCorrectness.checkLiterals(CrypterVerfahren.SUBSTITUTION,
                cypherText);
        String transformedMessage = "";

        int pointer = 0;
        for (int i = 0; i < cypherText.length(); i++) {
            int j = 0;

            while (cypherText.charAt(pointer) != (key.charAt(j))) {
                j++;

            }
            /*
             * catch the char on alphabet which is at the same position as found
             * at key
             */
            transformedMessage += CrypterVerfahren.SUBSTITUTION.getAlphabet()
                    .charAt(j);
            pointer++;

        }
        return transformedMessage;
    }
}
