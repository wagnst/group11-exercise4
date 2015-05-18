package de.wagnst.tpe.exercise.crypter;

public class IllegalKeyException extends Exception {
    private String key;

    public IllegalKeyException(String message, String key) {
        super(message);
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
