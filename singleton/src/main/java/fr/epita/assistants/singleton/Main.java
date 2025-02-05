package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;
import fr.epita.assistants.singleton.SingletonEnumLogger;
import fr.epita.assistants.singleton.StaticSingletonLogger;

public class Main {
    public static void main(String[] args) {
        testLogger(SingletonEnumLogger.INSTANCE);
        testLogger(StaticSingletonLogger.getInstance());
    }

    private static void testLogger(Logger logger) {
        System.err.println(logger.getInfoCounter()); // 0
        System.err.println(logger.getWarnCounter()); // 0
        System.err.println(logger.getErrorCounter()); // 0
        logger.log(Logger.Level.INFO, "Logger instantiated");
        logger.log(Logger.Level.WARN, "This is a warning message");
        System.err.println(logger.getInfoCounter()); // 1
        System.err.println(logger.getWarnCounter()); // 1
        System.err.println(logger.getErrorCounter()); // 0
        logger.log(Logger.Level.ERROR, "This is an error message");
        System.err.println(logger.getInfoCounter()); // 1
        System.err.println(logger.getWarnCounter()); // 1
        System.err.println(logger.getErrorCounter()); // 1

        logger.reset();

        System.err.println(logger.getInfoCounter()); // 0
        System.err.println(logger.getWarnCounter()); // 0
        System.err.println(logger.getErrorCounter()); // 0
    }
}
