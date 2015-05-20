package de.wagnst.tpe.exercise.crypter;

public class IllegalKeyException extends Exception {
    /* TODO warum final long variable? */
    private static final long serialVersionUID = 1L;
    private String message;
    private String name ="key";

    public IllegalKeyException() {

    }

    public IllegalKeyException(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message + " @ " + name;
    }

}
