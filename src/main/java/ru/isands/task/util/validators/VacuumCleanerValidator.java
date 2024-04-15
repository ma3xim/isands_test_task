package ru.isands.task.util.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.isands.task.models.Computer;
import ru.isands.task.models.VacuumCleaner;
import ru.isands.task.util.exceptions.EntityNotValidException;

@Component
public class VacuumCleanerValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return VacuumCleaner.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        VacuumCleaner vacuumCleaner = (VacuumCleaner) target;

        if (vacuumCleaner.getIsAvailable() == null){
            throw new EntityNotValidException("Поля не должны быть пустыми, null и должны быть валидными. ");
        }
    }
}
