package ru.isands.task.util.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.isands.task.models.Device;
import ru.isands.task.services.DeviceService;
import ru.isands.task.util.exceptions.EntityNotValidException;

@Component
public class DeviceValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Device.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Device device = (Device) target;

        if (!device.getName().equals("Компьютер") && !device.getName().equals("Смартфон") && !device.getName().equals("Холодильник")
                && !device.getName().equals("Пылесос") && !device.getName().equals("Телевизор")) {
            throw new EntityNotValidException("Имя нового вида техники должен быть одним из: Компьютер/Смартфон/Холодильник/Пылесос/Телевизор");
        }

        if (device.getIsInstallment() == null || device.getIsOnlineOrder() == null ) {
            throw new EntityNotValidException("Поля не должны быть пустыми, null и должны быть валидными. ");
        }

    }
}
