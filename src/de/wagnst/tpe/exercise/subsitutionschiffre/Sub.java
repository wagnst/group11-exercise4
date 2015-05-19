package de.wagnst.tpe.exercise.subsitutionschiffre;

import de.wagnst.tpe.exercise.crypter.*;

class Sub implements Crypter {

    private String cleartext = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String key;

    public String getCleartext() {
        return cleartext;
    }

    public void setKey(String key) {

        /* key contains exactly 26 letters */
        if (key.length() == 26) {
            this.key = key;
        }
        // TODO implement the case if the given key contains less than 26
        // letters
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
        try {
            if (key.length() != 26) {
                throw new IllegalKeyException(
                        "please insert a key within 26 letters", key);
            }
            /* TODO key does not match with encodeprocedure */

            String codedMessage = "";

            /* selects the letter to encode */
            int pointer = 0;
            /* loop over the whole message */
            for (int i = 0; i < message.length(); i++) {
                /* start from begin of key */
                int j = 0;
                while (message.charAt(pointer) != (cleartext.charAt(j))) {
                    j++;
                    if (j == 26) {
                        /* literal not at cleartext */
                        throw new IllegalMessageException(
                                "please ONLY use capital letters for your message",
                                message);
                    }
                }
                /* we found the letter in cleartext at position(j) */
                codedMessage += key.charAt(j);
                pointer++;
            }

            return codedMessage;

        } catch (IllegalKeyException e) {
            String keyException = e.getMessage();
            e.printStackTrace();
        } catch (IllegalMessageException e) {
            String messageException = e.getMessage();
            e.printStackTrace();
        }

        /* TODO WARUM DAS?? Wie geht man damit um? */
        return "";
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
    public String entschluesseln(String key, String cypherText)
            throws IllegalKeyException, IllegalMessageException {
        try {
            if (key.length() < 26) {
                throw new IllegalKeyException("wrong format at key", key);
            }

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

        } catch (IllegalKeyException e) {
            System.out.println("falscher Key!");
        }
        /* TODO WARUM DAS?? Wie geht man damit um? */
        return "";
    }
}
