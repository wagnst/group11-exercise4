package de.wagnst.tpe.exercise.subsitutionschiffre;

import de.wagnst.tpe.exercise.crypter.*;

public class CrypterSubstitution implements Crypter {

    /**
     * Verschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
     *
     * @param key Schlüssel, der verwendet werden soll.
     * @param message Nachricht, die Verschlüsselt werden soll.
     * @return verschlüsselter Text.
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

        message = MessageCorrectness.checkAndFormat(
                CrypterVerfahren.SUBSTITUTION, message);

        String transformedMessage = "";
        /* select the letter to encode */
        int pointer = 0;
        for (int i = 0; i < message.length(); i++) {
            /* start from begin of key */
            int j = 0;
            while (message.charAt(pointer) != (CrypterVerfahren.SUBSTITUTION
                    .getAlphabet().charAt(j))) {
                j++;

            }
            /* we found the letter in cleartext at position(j) */
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
     * @return entschlüsselter Text.
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

        cypherText = MessageCorrectness.checkAndFormat(
                CrypterVerfahren.SUBSTITUTION, cypherText);
        String transformedMessage = "";

        /* selects the letter to decode */
        int pointer = 0;
        /* loop over the whole message */
        for (int i = 0; i < cypherText.length(); i++) {
            /* start from begin of key */
            int j = 0;

            while (cypherText.charAt(pointer) != (key.charAt(j))) {
                j++;

            }
            /* we found the letter at position(j) */

            transformedMessage += CrypterVerfahren.SUBSTITUTION.getAlphabet()
                    .charAt(j);
            pointer++;

        }

        return transformedMessage;

    }
}
