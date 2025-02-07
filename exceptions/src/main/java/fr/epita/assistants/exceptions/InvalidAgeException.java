package fr.epita.assistants.exceptions;

class InvalidAgeException extends Exception {
    public InvalidAgeException(int age) {
        super("InvalidAgeException: " + age);
    }
}
