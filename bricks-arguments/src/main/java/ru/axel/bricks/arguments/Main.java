package ru.axel.bricks.arguments;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        /* Способ получения значения аргумента из командной строки через менеджер аргументов */
        String[] arg = { "config=test" };

        ArgumentsManager argumentsManager = new ArgumentsManager(arg) { };
        Optional<String> optionalConfig = argumentsManager.findArgByName("config");

        if (optionalConfig.isPresent()) {
            String argumentValue = argumentsManager.getArgValue(optionalConfig.get());
            System.out.println("test passed! " + argumentValue);
        } else {
            System.out.println("test bad");
        }
    }
}