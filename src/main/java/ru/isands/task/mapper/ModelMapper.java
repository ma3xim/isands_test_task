package ru.isands.task.mapper;

import ru.isands.task.dto.inputDto.ModelInputDTO;
import ru.isands.task.dto.outputDto.ModelOutputDTO;
import ru.isands.task.models.Model;

public class ModelMapper {
    public static ModelOutputDTO toOutputDto(Model model) {
        return ModelOutputDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .serialNumber(model.getSerialNumber())
                .color(model.getColor())
                .size(model.getSize())
                .price(model.getPrice())
                .isAvailable(model.getIsAvailable())
                .typeOfDevice(model.getTypeOfDevice())
                .build();
    }

    public static Model toModel(ModelInputDTO modelInputDTO) {
        Model model = new Model();
        model.setName(modelInputDTO.getName());
        model.setSerialNumber(modelInputDTO.getSerialNumber());
        model.setColor(modelInputDTO.getColor());
        model.setSize(modelInputDTO.getSize());
        model.setPrice(modelInputDTO.getPrice());
        model.setIsAvailable(modelInputDTO.getIsAvailable());
        return model;
    }
}
