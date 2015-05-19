package de.wagnst.tpe.exercise.crypter;

public class IllegalMessageException extends Exception {

    /**TODO warum das? 
     */
    private static final long serialVersionUID = 1L;
    private String userMessage;

    public IllegalMessageException() {

    }

    public IllegalMessageException(String message, String userMessage) {
        super(message);
        this.userMessage = userMessage;
    }

    public String getMessage() {
        return userMessage;
    }

}
