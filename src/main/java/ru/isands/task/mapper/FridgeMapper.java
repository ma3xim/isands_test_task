package ru.isands.task.mapper;

import ru.isands.task.dto.inputDto.FridgeInputDTO;
import ru.isands.task.dto.outputDto.FridgeOutputDTO;
import ru.isands.task.models.Fridge;

public class FridgeMapper {
    public static FridgeOutputDTO toOutputDto(Fridge fridge) {
        return FridgeOutputDTO.builder()
                .id(fridge.getId())
                .name(fridge.getName())
                .serialNumber(fridge.getSerialNumber())
                .color(fridge.getColor())
                .size(fridge.getSize())
                .price(fridge.getPrice())
                .isAvailable(fridge.getIsAvailable())
                .doors(fridge.getDoors())
                .compressorType(fridge.getCompressorType())
                .typeOfDevice(fridge.getTypeOfDevice())
                .deviceDTO(ModelDeviceMapper.toDto(fridge.getDevice()))
                .build();
    }

    public static Fridge toFridge(FridgeInputDTO fridgeInputDTO) {
        Fridge fridge = new Fridge();
        fridge.setName(fridgeInputDTO.getName());
        fridge.setPrice(fridgeInputDTO.getPrice());
        fridge.setSerialNumber(fridgeInputDTO.getSerialNumber());
        fridge.setSize(fridgeInputDTO.getSize());
        fridge.setColor(fridgeInputDTO.getColor());
        fridge.setIsAvailable(fridgeInputDTO.getIsAvailable());
        fridge.setDoors(fridgeInputDTO.getDoors());
        fridge.setCompressorType(fridgeInputDTO.getCompressorType());
        return fridge;
    }
}
