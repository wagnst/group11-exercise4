package de.wagnst.tpe.exercise.crypter;

/**
 * Is thrown if the message to encode/decode does not match with the message
 * given by user
 */
public class IllegalMessageException extends Exception {

    private String message;
    private String name = "Message";

    public IllegalMessageException() {

    }

    public IllegalMessageException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message + " @ " + name;
    }

}
