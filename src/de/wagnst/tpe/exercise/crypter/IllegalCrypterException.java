package de.wagnst.tpe.exercise.crypter;

/**
 * Copyright by Steffen Wagner (D059727)
 *
 * Created on 21.05.2015, 13:38 Project: group11-exercise4
 */

public class IllegalCrypterException extends Exception {
    private String message;
    private String name ="crypter";

    public IllegalCrypterException() {

    }

    public IllegalCrypterException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message + " @ " + name;
    }

}
