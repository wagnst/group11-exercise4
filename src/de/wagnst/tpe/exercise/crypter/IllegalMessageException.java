package de.wagnst.tpe.exercise.crypter;

public class IllegalMessageException extends Exception {

    private String userMessage;

    public IllegalMessageException(String message, String userMessage) {
        super(message);
        this.userMessage = userMessage;
    }

    public String getKey() {
        return userMessage;
    }

}
