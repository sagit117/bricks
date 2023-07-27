package ru.axel.bricks.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс для наследования, включает консольный логгер.
 */
public abstract class SimpleConsoleLoggable {
    private static final SimpleConsoleLoggerFactory simpleConsoleLoggerFactory = new SimpleConsoleLoggerFactory();

    protected final Logger logger;

    protected SimpleConsoleLoggable(Level level) {
        logger = simpleConsoleLoggerFactory.getLogger(this.getClass(), level);
    }
}
