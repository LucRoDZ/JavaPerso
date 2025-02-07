package fr.epita.assistants.exceptions;

class InvalidMajorException extends Exception {
    public InvalidMajorException(String major) {
        super("InvalidMajorException: " + major);
    }
}
