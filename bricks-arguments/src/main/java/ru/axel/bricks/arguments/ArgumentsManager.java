package ru.axel.bricks.arguments;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.axel.bricks.arguments.exceptions.ArgumentsIsNullException;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class ArgumentsManager {
    private final String[] arguments;

    @Contract(pure = true)
    protected ArgumentsManager(String[] arguments) {
        if (arguments != null) {
            this.arguments = arguments;
        } else {
            throw new ArgumentsIsNullException("Переданные аргументы имеют тип null, ожидаемый тип String[]");
        }
    }

    public Optional<String> findArgByName(String name) {
        final Stream<String> appConfigStream = Arrays.stream(arguments).filter(arg -> arg.startsWith(name + "="));
        return appConfigStream.findFirst();
    }

    public String getArgValue(@NotNull String argRawString) {
        final String[] value = argRawString.split("=");

        if (value.length > 1) return value[1];
        else return "";
    }
}
