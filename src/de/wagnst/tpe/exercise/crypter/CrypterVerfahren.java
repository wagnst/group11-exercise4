package de.wagnst.tpe.exercise.crypter;
/**
 * Copyright by Steffen Wagner (D059727)
 *
 * Created on 21.05.2015, 12:13 Project: group11-exercise4
 */

public enum CrypterVerfahren {
    SUBSTITUTION("Substitution", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 26, 26),
    CAESAR("Caesar", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1, 1),
    XOR("XOR", "@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_");

    private final String name;
    private final String alphabet;
    private final int minKeyLength;
    private final int maxKeyLength;

    /**
     * Constructor used for XOR encryption, because it does not need key length
     *
     * @param alphabet String of allowed chars for usage in encryption
     */
    private CrypterVerfahren(String name, String alphabet) {
        this.name = name;
        this.alphabet = alphabet;
        minKeyLength = -1;
        maxKeyLength = -1;
    }

    /**
     * Contructor used for Substitution and Caesar encryption
     *
     * @param alphabet String of allowed chars for usage in encryption
     * @param minKeyLength minimum length of key that is allowed
     * @param maxKeyLength maximum length of key that is allowed
     */
    private CrypterVerfahren(String name, String alphabet, int minKeyLength, int maxKeyLength) {
        this.name = name;
        this.alphabet = alphabet;
        this.minKeyLength = minKeyLength;
        this.maxKeyLength = maxKeyLength;
    }

    public String getName() {
        return this.name;
    }
    public String getAlphabet() {
        return this.alphabet;
    }

    public int getMinKeyLength() {
        return this.minKeyLength;
    }

    public int getMaxKeyLength() {
        return this.maxKeyLength;
    }
}
