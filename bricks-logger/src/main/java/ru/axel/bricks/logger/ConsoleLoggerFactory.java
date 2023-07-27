package ru.axel.bricks.logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;

/**
 * Базовый класс для создания фабрики консольных логгеров.
 */
public abstract class ConsoleLoggerFactory extends LoggerFactory {
    protected ConsoleLoggerFactory(Formatter formatter) {
        super(formatter, new ConsoleHandler());
    }
}
