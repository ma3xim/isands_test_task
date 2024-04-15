package ru.isands.task.mapper;

import ru.isands.task.dto.inputDto.TvInputDTO;
import ru.isands.task.dto.outputDto.TvOutputDTO;
import ru.isands.task.models.Tv;

public class TvMapper {
    public static TvOutputDTO toOutputDto(Tv tv) {
        return TvOutputDTO.builder()
                .id(tv.getId())
                .name(tv.getName())
                .serialNumber(tv.getSerialNumber())
                .color(tv.getColor())
                .size(tv.getSize())
                .price(tv.getPrice())
                .isAvailable(tv.getIsAvailable())
                .category(tv.getCategory())
                .technology(tv.getTechnology())
                .typeOfDevice(tv.getTypeOfDevice())
                .deviceDTO(ModelDeviceMapper.toDto(tv.getDevice()))
                .build();
    }

    public static Tv toTv(TvInputDTO tvInputDTO) {
        Tv tv = new Tv();
        tv.setName(tvInputDTO.getName());
        tv.setPrice(tvInputDTO.getPrice());
        tv.setSerialNumber(tvInputDTO.getSerialNumber());
        tv.setSize(tvInputDTO.getSize());
        tv.setColor(tvInputDTO.getColor());
        tv.setIsAvailable(tvInputDTO.getIsAvailable());
        tv.setCategory(tvInputDTO.getCategory());
        tv.setTechnology(tvInputDTO.getTechnology());
        return tv;
    }
}
