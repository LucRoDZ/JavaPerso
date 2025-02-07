package fr.epita.assistants.loggingThreads;

import java.math.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeWaster {
    // FIXME: Logger
    private static final Logger logger = LoggerFactory.getLogger(TimeWaster.class);

    public TimeWaster() {
        // FIXME: Initialize logger with level TRACE
        ((ch.qos.logback.classic.Logger) logger).setLevel(ch.qos.logback.classic.Level.TRACE);
    }

    /**
     * @param n Last natural number to sum
     * @return The sum of integers from 0 to n
     */
    public BigInteger sumUpTo(int n) {
        // FIXME: Add logging
        logger.trace("Calculating");

        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= n; i++) {
            sum = sum.add(BigInteger.valueOf(i));
        }

        logger.debug("Finished calculating sum up to {}: {}", n, sum);

        return sum;
    }

    public void doImportantThing() {
        // FIXME: Wait for 2s, logging an error in case of interruption
        logger.info("Waiting");
        try {
            Thread.sleep(2000);
            logger.info("Successfully waited");
        } catch (InterruptedException e) {
            logger.error("Wait interrupted", e);
            Thread.currentThread().interrupt();
        }
    }
}
