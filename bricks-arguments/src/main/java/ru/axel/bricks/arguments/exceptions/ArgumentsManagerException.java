package ru.axel.bricks.arguments.exceptions;

public abstract class ArgumentsManagerException extends RuntimeException {
    protected ArgumentsManagerException(String msg) {
        super(msg);
    }
}
