package ru.isands.task.mapper;

import ru.isands.task.dto.outputDto.DeviceDTO;
import ru.isands.task.models.Device;

public class ModelDeviceMapper {
    public static DeviceDTO toDto(Device device) {
        return DeviceDTO.builder()
                .id(device.getId())
                .name(device.getName())
                .countryManufacturer(device.getCountryManufacturer())
                .companyManufacturer(device.getCompanyManufacturer())
                .isOnlineOrder(device.getIsOnlineOrder())
                .isInstallment(device.getIsInstallment())
                .build();
    }
}
