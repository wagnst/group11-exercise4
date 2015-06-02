package de.wagnst.tpe.exercise.crypter;

/**
 * Exception which can be thrown if an illegal crypter is used
 *
 * @author wagnst
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
