package ru.isands.task.mapper;

import ru.isands.task.dto.inputDto.PhoneInputDTO;
import ru.isands.task.dto.outputDto.PhoneOutputDTO;
import ru.isands.task.models.Phone;

public class PhoneMapper {
    public static PhoneOutputDTO toOutputDto(Phone phone) {
        return PhoneOutputDTO.builder()
                .id(phone.getId())
                .name(phone.getName())
                .serialNumber(phone.getSerialNumber())
                .color(phone.getColor())
                .size(phone.getSize())
                .price(phone.getPrice())
                .isAvailable(phone.getIsAvailable())
                .cameras(phone.getCameras())
                .memory(phone.getMemory())
                .typeOfDevice(phone.getTypeOfDevice())
                .deviceDTO(ModelDeviceMapper.toDto(phone.getDevice()))
                .build();
    }

    public static Phone toPhone(PhoneInputDTO phoneInputDTO) {
        Phone phone = new Phone();
        phone.setName(phoneInputDTO.getName());
        phone.setPrice(phoneInputDTO.getPrice());
        phone.setSerialNumber(phoneInputDTO.getSerialNumber());
        phone.setSize(phoneInputDTO.getSize());
        phone.setColor(phoneInputDTO.getColor());
        phone.setIsAvailable(phoneInputDTO.getIsAvailable());
        phone.setCameras(phoneInputDTO.getCameras());
        phone.setMemory(phoneInputDTO.getMemory());
        return phone;
    }
}
