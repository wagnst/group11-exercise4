package de.wagnst.tpe.exercise.crypter;

/**
 * Is thrown if the key does not match the key needed for encode/decode method
 */
public class IllegalKeyException extends Exception {

    private String message;
    private String name = "key";

    public IllegalKeyException() {

    }

    public IllegalKeyException(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message + "\n check " + name;
    }

}
