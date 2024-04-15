package ru.isands.task.mapper;

import ru.isands.task.dto.inputDto.ComputerInputDTO;
import ru.isands.task.dto.outputDto.ComputerOutputDTO;
import ru.isands.task.models.Computer;

public class ComputerMapper {
    public static ComputerOutputDTO toOutputDto(Computer computer) {
        return ComputerOutputDTO.builder()
                .id(computer.getId())
                .name(computer.getName())
                .serialNumber(computer.getSerialNumber())
                .color(computer.getColor())
                .size(computer.getSize())
                .price(computer.getPrice())
                .isAvailable(computer.getIsAvailable())
                .category(computer.getCategory())
                .processorType(computer.getProcessorType())
                .typeOfDevice(computer.getTypeOfDevice())
                .deviceDTO(ModelDeviceMapper.toDto(computer.getDevice()))
                .build();
    }

    public static Computer toComputer(ComputerInputDTO computerInputDto) {
        Computer computer = new Computer();
        computer.setName(computerInputDto.getName());
        computer.setPrice(computerInputDto.getPrice());
        computer.setSerialNumber(computerInputDto.getSerialNumber());
        computer.setSize(computerInputDto.getSize());
        computer.setColor(computerInputDto.getColor());
        computer.setIsAvailable(computerInputDto.getIsAvailable());
        computer.setProcessorType(computerInputDto.getProcessorType());
        computer.setCategory(computerInputDto.getCategory());
        return computer;
    }
}
