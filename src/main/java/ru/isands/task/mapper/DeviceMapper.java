package ru.isands.task.mapper;

import ru.isands.task.dto.inputDto.DeviceInputDTO;
import ru.isands.task.dto.outputDto.DeviceOutputDTO;
import ru.isands.task.models.Device;

import java.util.Collections;
import java.util.stream.Collectors;

public class DeviceMapper {
    public static DeviceOutputDTO toOutputDTO(Device device) {
        return DeviceOutputDTO.builder()
                .id(device.getId())
                .name(device.getName())
                .countryManufacturer(device.getCountryManufacturer())
                .companyManufacturer(device.getCompanyManufacturer())
                .isOnlineOrder(device.getIsOnlineOrder())
                .isInstallment(device.getIsInstallment())
                .models(device.getModels() != null ? device.getModels()
                        .stream()
                        .map(ModelMapper::toOutputDto)
                        .collect(Collectors.toList()) : Collections.emptyList())
                .build();
    }

    public static Device toDevice(DeviceInputDTO deviceInputDTO) {
        Device device = new Device();
        device.setName(deviceInputDTO.getName());
        device.setCountryManufacturer(deviceInputDTO.getCountryManufacturer());
        device.setCompanyManufacturer(deviceInputDTO.getCompanyManufacturer());
        device.setIsOnlineOrder(deviceInputDTO.getIsOnlineOrder());
        device.setIsInstallment(deviceInputDTO.getIsInstallment());
        return device;
    }
}
