package ru.isands.task.util.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.isands.task.models.Computer;
import ru.isands.task.models.Fridge;
import ru.isands.task.util.exceptions.EntityNotValidException;

@Component
public class FridgeValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Fridge.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Fridge fridge = (Fridge) target;

        if (fridge.getIsAvailable() == null){
            throw new EntityNotValidException("Поля не должны быть пустыми, null и должны быть валидными. ");
        }

    }
}
