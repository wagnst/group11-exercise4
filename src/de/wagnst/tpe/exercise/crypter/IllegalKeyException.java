package de.wagnst.tpe.exercise.crypter;

public class IllegalKeyException extends Exception {
    /*TODO warum das??*/
    private static final long serialVersionUID = 1L;
    private String message;

    public IllegalKeyException() {

    }

    public IllegalKeyException(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
