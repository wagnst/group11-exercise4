package de.wagnst.tpe.exercise.crypter;

public class IllegalKeyException extends Exception {

    private String message;
    private String name = "key";

    public IllegalKeyException() {

    }

    public IllegalKeyException(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message + " @ " + name;
    }

}
