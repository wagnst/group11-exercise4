package de.wagnst.tpe.exercise.subsitutionschiffre;

import de.wagnst.tpe.exercise.crypter.*;

public class Substi implements Crypter {

    private String cleartext = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String getCleartext() {
        return cleartext;
    }

    /**
     * Verschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
     *
     * @param key Schlüssel, der verwendet werden soll.
     * @param message Nachricht, die Verschlüsselt werden soll.
     *
     * @return verschlüsselter Text.
     * @throws IllegalKeyException Wird geworfen, wenn der Schlüssel nicht zum
     *         Verschlüsselungsverfahren passt
     * @throws IllegalMessageException Wird geworfen, wenn die Nachricht
     *         unerlaubte Zeichen enthält.
     */
    @Override
    public String verschluesseln(String key, String message)
            throws IllegalKeyException, IllegalMessageException {

        /* TODO method for each Exception check forXY */
        /* TODO catch the spaces at message input */
        /* TODO catch illegal literals at message input */

        String codedMessage = "";

        if (key.length() != 26) {
            throw new IllegalKeyException(
                    "please insert a key within 26 letters");
        }
        /* checks whole key for illegal literals */
        for (int i = 0; i < key.length(); i++) {
            if (!cleartext.contains((Character.toString(key.charAt(i))))) {
                throw new IllegalKeyException(
                        "please Only use capital letters for your key");
            }
        }

        /* searching for duplicate letters, includes spaces */
        for (int i = 0; i < key.length(); i++) {
            int count = 0;
            for (int j = 0; j < key.length(); j++) {
                if (key.charAt(i) == key.charAt(j)) {
                    count++;
                    if (count > 1) {
                        throw new IllegalKeyException(
                                "duplicates are not allowed at key");
                    }

                }
            }
        }

        /* select the letter to encode */
        int pointer = 0;
        for (int i = 0; i < message.length(); i++) {
            /* start from begin of key */
            int j = 0;
            while (message.charAt(pointer) != (cleartext.charAt(j))) {
                j++;

                try {
                    if (j == 26) {
                        /* literal not at cleartext */
                        throw new IllegalMessageException(
                                "please ONLY use capital letters for your message",
                                message);
                    }
                } catch (IllegalMessageException e) {
                    System.out.println(e.getMessage());
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
     *
     * @return entschlüsselter Text.
     * @throws IllegalKeyException Wird geworfen, wenn der Schlüssel nicht zum
     *         Verschlüsselungsverfahren passt
     * @throws IllegalMessageException Wird geworfen, wenn die Nachricht
     *         unerlaubte Zeichen enthält.
     */
    @Override
    public String entschluesseln(String key, String cypherText) {

        String decodedMessage = "";

        /* selects the letter to decode */
        int pointer = 0;
        /* loop over the whole message */
        for (int i = 0; i < cypherText.length(); i++) {
            /* start from begin of key */
            int j = 0;

            /* TODO do we need this? */
            /* may spaces appear */
            if (cypherText.charAt(pointer) == ' ') {
                decodedMessage += ' ';
            } else {
                while (cypherText.charAt(pointer) != (key.charAt(j))) {
                    j++;
                }
                /* we found the letter in cleartext at position(j) */
                decodedMessage += cleartext.charAt(j);
            }

            pointer++;
        }

        return decodedMessage;

    }
}
