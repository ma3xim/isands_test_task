package ru.isands.task.util.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.isands.task.models.Computer;
import ru.isands.task.models.Tv;
import ru.isands.task.util.exceptions.EntityNotValidException;

@Component
public class TvValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Tv.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Tv tv = (Tv) target;

        if (tv.getIsAvailable() == null){
            throw new EntityNotValidException("Поля не должны быть пустыми, null и должны быть валидными. ");
        }

    }
}
