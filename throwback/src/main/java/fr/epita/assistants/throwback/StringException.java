package fr.epita.assistants.throwback;

public abstract class StringException extends Exception {
    public StringException(String message, int length) {
        super("StringException: " + message + " (length: " + length + ")");
    }
}
