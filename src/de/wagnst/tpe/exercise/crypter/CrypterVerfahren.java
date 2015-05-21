package de.wagnst.tpe.exercise.crypter;

public enum CrypterVerfahren {
    SUBSTITUTION("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 26, 26),
    CAESAR("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1, 1),
    XOR("@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_");

    private final String alphabet;
    private final int minKeyLength;
    private final int maxKeyLength;

    private CrypterVerfahren(String alphabet) {
        this.alphabet = alphabet;
        minKeyLength = -1;
        maxKeyLength = -1;
    }

    private CrypterVerfahren(String alphabet, int minKeyLength, int maxKeyLength) {
        this.alphabet = alphabet;
        this.minKeyLength = minKeyLength;
        this.maxKeyLength = maxKeyLength;
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
