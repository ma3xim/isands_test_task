package ru.isands.task.util.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.isands.task.models.Computer;
import ru.isands.task.models.Device;
import ru.isands.task.services.ComputerService;
import ru.isands.task.util.exceptions.EntityNotValidException;

@Component
public class ComputerValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Computer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Computer computer = (Computer) target;

        if (computer.getIsAvailable() == null){
            throw new EntityNotValidException("Поля не должны быть пустыми, null и должны быть валидными. ");
        }

    }
}
