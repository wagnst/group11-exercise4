package de.wagnst.tpe.exercise.crypter;

public class IllegalMessageException extends Exception {

    /**
     * TODO warum das?
     */
    private static final long serialVersionUID = 1L;

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
