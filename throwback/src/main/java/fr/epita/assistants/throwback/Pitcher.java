package fr.epita.assistants.throwback;

public class Pitcher {
    public static void throwException(String message) throws
            LongStringException, ShortStringException,
            PositiveIntegerException, NegativeIntegerException,
            UnknownException {

        if (message.matches("-?\\d+")) {
            int number = Integer.parseInt(message);
            if (number >= 0) {
                throw new PositiveIntegerException(message);
            } else {
                throw new NegativeIntegerException(message);
            }
        } else if (message.matches("[a-zA-Z ,.'-]+")) {
            if (message.length() >= 100) {
                throw new LongStringException(message);
            } else {
                throw new ShortStringException(message);
            }
        } else {
            throw new UnknownException(message);
        }
    }
}