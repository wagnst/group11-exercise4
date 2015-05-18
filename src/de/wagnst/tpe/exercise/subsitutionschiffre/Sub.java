package de.wagnst.tpe.exercise.subsitutionschiffre;

import de.wagnst.tpe.exercise.crypter.*;

class Sub implements Crypter {

    /*
     * private char[] cleartext = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
     * 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
     * 'X', 'Y', 'Z' };
     */

    private String cleartext = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String key;

    public Sub() {

    }

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

    @Override
    public String verschluesseln(String key, String message)
            throws IllegalKeyException, IllegalMessageException {
        try {
            if (key.length() < 26) {
                throw new IllegalKeyException("wrong format at key", key);
            }
            String codedMessage = "";

            /* selects the letter to decode */
            int pointer = 0;
            /* loop over the whole message */
            // TODO delete spaces!!
            for (int i = 0; i < message.length(); i++) {
                /* start from begin of key */
                int j = 0;
                while (message.charAt(pointer) != (cleartext.charAt(j))) {
                    j++;
                }
                /* we found the letter in cleartext at position(j) */
                codedMessage += key.charAt(j);
                pointer++;
            }

            return codedMessage;

        } catch (IllegalKeyException e) {
            System.out.println("falscher Key!");
        }
    }

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
    }
}
