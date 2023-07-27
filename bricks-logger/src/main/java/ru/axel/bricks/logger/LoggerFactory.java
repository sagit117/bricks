package ru.axel.bricks.logger;

import org.jetbrains.annotations.NotNull;

import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

/**
 * Базовый класс для создания фабрики логгеров.
 */
public abstract class LoggerFactory {
    final private Formatter formatterInstance;
    final private StreamHandler handler;

    protected LoggerFactory(Formatter formatter, StreamHandler handler) {
        formatterInstance = formatter;
        this.handler = handler;
    }

    /**
     * Метод получения логера с форматом по умолчанию.
     * @param tClass класс, который необходимо логировать.
     * @param level уровень лога.
     * @return объект логера с форматом по умолчанию.
     */
    public @NotNull Logger getLogger(@NotNull Class<?> tClass, Level level) {
        final Logger logger = getLoggerInstance(tClass, level);
        setHandler(logger, handler, formatterInstance);

        return logger;
    }

    private void setHandler(@NotNull Logger logger, StreamHandler handler, Formatter formatter) {
        if (logger.getHandlers().length == 0) {
            handler.setFormatter(formatter);
            logger.addHandler(handler);
        }
    }

    private @NotNull Logger getLoggerInstance(@NotNull Class<?> tClass, Level level) {
        final Logger logger = Logger.getLogger(tClass.getName());
        logger.setUseParentHandlers(false);
        logger.setLevel(level);

        return logger;
    }
}
