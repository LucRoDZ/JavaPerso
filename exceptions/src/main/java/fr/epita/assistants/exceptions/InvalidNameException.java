package fr.epita.assistants.exceptions;

class InvalidNameException extends Exception {
    public InvalidNameException(String name) {
        super("InvalidNameException: " + name);
    }
}
