package de.wagnst.tpe.exercise.ceasarverschluesselung;


import de.wagnst.tpe.exercise.crypter.*;

public class CrypterCaesar implements Crypter{


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

        KeyCorrectness.checkLength(CrypterVerfahren.CAESAR, key);
        KeyCorrectness.checkLiterals(CrypterVerfahren.CAESAR, key);
        KeyCorrectness.checkDuplicates(CrypterVerfahren.CAESAR, key);

        char keychar = key.charAt(0);
        int keyint = keychar - 65;
        String transformedMessage = "";




        return transformedMessage;
    }

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

        KeyCorrectness.checkLength(CrypterVerfahren.CAESAR, key);
        KeyCorrectness.checkLiterals(CrypterVerfahren.CAESAR, key);
        KeyCorrectness.checkDuplicates(CrypterVerfahren.CAESAR, key);

        message = MessageCorrectness.checkAndFormat(
                CrypterVerfahren.CAESAR, message);

        return null;
    }
}
