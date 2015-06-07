package de.wagnst.tpe.exercise.crypter;

/**
 * Enum which contains all possible crypters like xor, caesar and substition. It
 * saves a name, an alphabet, min and max keylengths as well a range text.
 *
 * @author wagnst
 */

public enum CrypterVerfahren {
    SUBSTITUTION("Substitution", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 26, 26, "exactly 26 letters"),
    CAESAR("Caesar", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1, 1, "exactly 1 letter"),
    XOR("XOR", "@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_", "min 1 literal"),
    NEW_CIPHER("NEW_CIPHER", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 26, 26, "exactly 26 letters");

    private final String name;
    private final String alphabet;
    private final int minKeyLength;
    private final int maxKeyLength;
    private final String keyRange;

    /**
     * Constructor used for XOR encryption, because it does not need key length
     *
     * @param alphabet String of allowed chars for usage in encryption
     */
    private CrypterVerfahren(String name, String alphabet, String keyRange) {
        this.name = name;
        this.alphabet = alphabet;
        this.keyRange = keyRange;
        this.minKeyLength = 1;
        this.maxKeyLength = -1;
    }

    /**
     * Contructor used for Substitution and Caesar encryption
     *
     * @param alphabet     String of allowed chars for usage in encryption
     * @param minKeyLength minimum length of key that is allowed
     * @param maxKeyLength maximum length of key that is allowed
     */
    private CrypterVerfahren(String name, String alphabet, int minKeyLength,
                             int maxKeyLength, String keyRange) {
        this.name = name;
        this.alphabet = alphabet;
        this.minKeyLength = minKeyLength;
        this.maxKeyLength = maxKeyLength;
        this.keyRange = keyRange;
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

    public String getKeyRange() {
        return this.keyRange;
    }
}
