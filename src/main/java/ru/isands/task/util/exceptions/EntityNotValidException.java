package ru.isands.task.util.exceptions;

public class EntityNotValidException extends RuntimeException{
    public EntityNotValidException(String message) {
        super(message);
    }
}
