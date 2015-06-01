package de.wagnst.tpe.exercise.crypter;

/*
 * TODO durch diese Exception wird das Interface verändert .. denn es wird eine
 * weitere Exception erwartet
 */
/**
 * Copyright by Steffen Wagner (D059727)
 * <p/>
 * Created on 21.05.2015, 13:38 Project: group11-exercise4
 */

public class IllegalCrypterException extends Exception {

    private static final long serialVersionUID = 1L;
    private String message;
    private String name = "crypter";

    public IllegalCrypterException() {

    }

    public IllegalCrypterException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message + "\n check " + name;
    }

}
