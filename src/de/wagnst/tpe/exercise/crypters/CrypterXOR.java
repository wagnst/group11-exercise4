package de.wagnst.tpe.exercise.crypters;

import de.wagnst.tpe.exercise.crypter.*;

/**
 * Copyright by Steffen Wagner (D059727)
 * <p/>
 * Created on 21.05.2015, 12:13 Project: group11-exercise4
 */

/* TODO Klassenbeschreibung & allegemeinen JavaDoc für Methoden */
class CrypterXOR implements Crypter {

    /**
     * @see de.wagnst.tpe.exercise.crypter
     */
    @Override
    public String verschluesseln(String key, String message)
            throws IllegalKeyException, IllegalMessageException {

        int xor;
        char temp;
        String transformedMessage = "";

        /* Check key for correctness */
        KeyCorrectness.checkLength(CrypterVerfahren.XOR, key);
        KeyCorrectness.checkLiterals(CrypterVerfahren.XOR, key);

        /* Check the message correctness */
        MessageCorrectness.checkLength(CrypterVerfahren.XOR, message);
        MessageCorrectness.checkLiterals(CrypterVerfahren.XOR, message);

        for (int i = 0; i < message.length(); i++) {
            xor = message.charAt(i) ^ key.charAt(i);
            temp = (char) xor;
            transformedMessage += CrypterVerfahren.XOR.getAlphabet().charAt(temp);
        }

        return transformedMessage;
    }

    /**
     * @see de.wagnst.tpe.exercise.crypter
     */
    @Override
    public String entschluesseln(String key, String cypherText)
            throws IllegalKeyException, IllegalMessageException {

        int xor;
        char temp;
        String transformedMessage = "";

        /* Check key for correctness */
        KeyCorrectness.checkLength(CrypterVerfahren.XOR, key);
        KeyCorrectness.checkLiterals(CrypterVerfahren.XOR, key);

        /* Check the message correctness */
        MessageCorrectness.checkLength(CrypterVerfahren.XOR, cypherText);
        MessageCorrectness.checkLiterals(CrypterVerfahren.XOR, cypherText);

        for (int i = 0; i < cypherText.length(); i++) {
            xor = cypherText.charAt(i) ^ key.charAt(i);
            temp = (char) xor;
            transformedMessage += CrypterVerfahren.XOR.getAlphabet().charAt(temp);
        }

        return transformedMessage;
    }
}
