package ru.axel.bricks.logger;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

/**
 * Класс фабрики консольных логгеров.
 */
public final class SimpleConsoleLoggerFactory extends ConsoleLoggerFactory {
    private static final String format = "%1$tF %1$tT [%2$-7s] thread: [%3$s] %4$s %5$s: %6$s %n";
    private static final Formatter formatterInstance = getFormatter(format);

    public SimpleConsoleLoggerFactory() {
        super(formatterInstance);
    }

    @Contract(" _ -> new")
    private static @NotNull Formatter getFormatter(String formatString) {
        return new SimpleFormatter() {
            public synchronized String format(LogRecord lr) {
                return String.format(
                        formatString,
                        new Date(lr.getMillis()),
                        lr.getLevel().getLocalizedName(),
                        Thread.currentThread().getName(),
                        lr.getLoggerName(),
                        lr.getSourceMethodName(),
                        lr.getMessage()
                );
            }
        };
    }
}
