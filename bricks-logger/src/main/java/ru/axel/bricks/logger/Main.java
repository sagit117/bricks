package ru.axel.bricks.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        /* Способ создать логгер */
        SimpleConsoleLoggerFactory simpleConsoleLoggerFactory = new SimpleConsoleLoggerFactory();
        Logger logger = simpleConsoleLoggerFactory.getLogger(Main.class, Level.ALL);

        logger.severe("test");

        /* Способ передать логгер через наследование */
        TestLoggable testLoggable = new TestLoggable(Level.ALL);
        testLoggable.logIt("Test 2");
    }

    /**
     * Способ передать логгер через наследование
     */
    private static class TestLoggable extends SimpleConsoleLoggable {

        protected TestLoggable(Level level) {
            super(level);
        }

        void logIt(String text) {
            logger.severe(text);
        }
    }

}