package ru.isands.task.mapper;

import ru.isands.task.dto.inputDto.VacuumCleanerInputDTO;
import ru.isands.task.dto.outputDto.VacuumCleanerOutputDTO;
import ru.isands.task.models.VacuumCleaner;

public class VacuumCleanerMapper {
    public static VacuumCleanerOutputDTO toOutputDto(VacuumCleaner vacuumCleaner) {
        return VacuumCleanerOutputDTO.builder()
                .id(vacuumCleaner.getId())
                .name(vacuumCleaner.getName())
                .serialNumber(vacuumCleaner.getSerialNumber())
                .color(vacuumCleaner.getColor())
                .size(vacuumCleaner.getSize())
                .price(vacuumCleaner.getPrice())
                .isAvailable(vacuumCleaner.getIsAvailable())
                .dustBagCapacity(vacuumCleaner.getDustBagCapacity())
                .cleanerModes(vacuumCleaner.getCleanerModes())
                .typeOfDevice(vacuumCleaner.getTypeOfDevice())
                .deviceDTO(ModelDeviceMapper.toDto(vacuumCleaner.getDevice()))
                .build();
    }

    public static VacuumCleaner toVacuumCleaner(VacuumCleanerInputDTO vacuumCleanerInputDTO) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        vacuumCleaner.setName(vacuumCleanerInputDTO.getName());
        vacuumCleaner.setPrice(vacuumCleanerInputDTO.getPrice());
        vacuumCleaner.setSerialNumber(vacuumCleanerInputDTO.getSerialNumber());
        vacuumCleaner.setSize(vacuumCleanerInputDTO.getSize());
        vacuumCleaner.setColor(vacuumCleanerInputDTO.getColor());
        vacuumCleaner.setIsAvailable(vacuumCleanerInputDTO.getIsAvailable());
        vacuumCleaner.setDustBagCapacity(vacuumCleanerInputDTO.getDustBagCapacity());
        vacuumCleaner.setCleanerModes(vacuumCleanerInputDTO.getCleanerModes());
        return vacuumCleaner;
    }
}
