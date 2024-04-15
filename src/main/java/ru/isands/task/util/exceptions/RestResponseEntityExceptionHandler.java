package ru.isands.task.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleConflictException(EntityNotValidException ex) {
        return new ResponseEntity<>(new ErrorResponse("Сущность не валидна: " + ex.getMessage(), System.currentTimeMillis()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse("Сущность не найдена: " + ex.getMessage(), System.currentTimeMillis()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleInvalidSortTypeException(InvalidSortTypeException ex) {
        return new ResponseEntity<>(new ErrorResponse("Неверный тип сортировки: " + ex.getMessage(), System.currentTimeMillis()),
                HttpStatus.NOT_FOUND);
    }


}

