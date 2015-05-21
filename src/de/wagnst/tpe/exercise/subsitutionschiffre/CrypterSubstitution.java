package de.wagnst.tpe.exercise.subsitutionschiffre;

import de.wagnst.tpe.exercise.crypter.Crypter;
import de.wagnst.tpe.exercise.crypter.CrypterVerfahren;
import de.wagnst.tpe.exercise.crypter.IllegalKeyException;
import de.wagnst.tpe.exercise.crypter.IllegalMessageException;
import de.wagnst.tpe.exercise.crypter.KeyCorrectness;

public class CrypterSubstitution implements Crypter {

    private String cleartext = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String getCleartext() {
        return cleartext;
    }

    /* to prevent system performance set max. letters */
    private int howManyLetters = 10000;

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

        String codedMessage = "";
        /* select the letter to encode */
        int pointer = 0;
        for (int i = 0; i < message.length(); i++) {
            /* start from begin of key */
            int j = 0;
            while (message.charAt(pointer) != (CrypterVerfahren.SUBSTITUTION
                    .getAlphabet().charAt(j))) {
                j++;

                if (j == key.length()) {
                    /* literal not at cleartext */
                    throw new IllegalMessageException(
                            "please only use latin letters");
                }

            }
            /* we found the letter in cleartext at position(j) */
            codedMessage += key.charAt(j);
            pointer++;
        }

        return codedMessage;

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
        /* key correctness */
        /* length of key correct? */
        if (key.length() != 26) {
            throw new IllegalKeyException("please insert within 26 letters");
        }

        /* all letters correct for the key? */

        /* does key contain duplicates? */
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

        String decodedMessage = "";

        /* selects the letter to decode */
        int pointer = 0;
        /* loop over the whole message */
        for (int i = 0; i < cypherText.length(); i++) {
            /* start from begin of key */
            int j = 0;

            while (cypherText.charAt(pointer) != (key.charAt(j))) {
                j++;

                if (j == key.length()) {
                    throw new IllegalMessageException(
                            "please only use latin letters");
                }
            }
            /* we found the letter in cleartext at position(j) */
            decodedMessage += cleartext.charAt(j);
        }

        pointer++;

        return decodedMessage;

    }
}
