package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;

public class StaticSingletonLogger implements Logger {
    private int infoCounter = 0;
    private int warnCounter = 0;
    private int errorCounter = 0;

    private static class InstanceHolder {
        private static final StaticSingletonLogger _INSTANCE = new StaticSingletonLogger();
    }

    public static StaticSingletonLogger getInstance() {
        return InstanceHolder._INSTANCE;
    }

    @Override
    public void log(Level level, String message) {
        System.err.println(Logger.getFormattedLog(level, message));
        switch (level) {
            case INFO -> infoCounter += 1;
            case WARN -> warnCounter += 1;
            case ERROR -> errorCounter += 1;
        }
    }

    @Override
    public int getInfoCounter() {
        return infoCounter;
    }

    @Override
    public int getWarnCounter() {
        return warnCounter;
    }

    @Override
    public int getErrorCounter() {
        return errorCounter;
    }

    @Override
    public void reset() {
        infoCounter = 0;
        warnCounter = 0;
        errorCounter = 0;
    }
}
