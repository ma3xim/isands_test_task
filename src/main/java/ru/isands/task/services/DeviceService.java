package ru.isands.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.task.dto.outputDto.DeviceOutputDTO;
import ru.isands.task.dto.outputDto.ModelOutputDTO;
import ru.isands.task.mapper.DeviceMapper;
import ru.isands.task.mapper.ModelMapper;
import ru.isands.task.models.Device;
import ru.isands.task.models.Model;
import ru.isands.task.repositories.DeviceRepository;
import ru.isands.task.repositories.ModelRepository;
import ru.isands.task.services.searchAndFilters.ModelsSearchAndFilter;
import ru.isands.task.util.exceptions.InvalidSortTypeException;
import ru.isands.task.util.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final ModelsSearchAndFilter modelsSearchAndFilter;
    private final ModelRepository modelRepository;


    @Autowired
    public DeviceService(DeviceRepository deviceRepository, ModelsSearchAndFilter modelsSearchAndFilter, ModelRepository modelRepository) {
        this.deviceRepository = deviceRepository;
        this.modelsSearchAndFilter = modelsSearchAndFilter;
        this.modelRepository = modelRepository;
    }

    public List<DeviceOutputDTO> findAllDevices() {
        return deviceRepository.findAll().stream().map(device -> DeviceMapper.toOutputDTO(device)).collect(Collectors.toList());
    }

    public DeviceOutputDTO findById(Integer id) {
        return DeviceMapper.toOutputDTO(deviceRepository.findById(id).orElseThrow(() -> new NotFoundException("Техника с таким ID не найдена")));
    }


    @Transactional
    public void save(Device device) {
        deviceRepository.save(device);
    }

    public List<ModelOutputDTO> getWithSearch(String name, String color, Double minPrice, Double maxPrice) {
        List<Model> models = modelsSearchAndFilter.search(name, color, minPrice, maxPrice);

        return models.stream()
                .map(model -> ModelMapper.toOutputDto(model))
                .collect(Collectors.toList());
    }

    public List<ModelOutputDTO> sortByName(String sortType) {
        try {
            return modelRepository.findAll(Sort.by(Sort.Direction.fromString(sortType), "name"))
                    .stream()
                    .map(model -> ModelMapper.toOutputDto(model))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new InvalidSortTypeException("Должен быть ASC или DESC");
        }
    }

    public List<ModelOutputDTO> sortByPrice(String sortType) {
        try {
            return modelRepository.findAll(Sort.by(Sort.Direction.fromString(sortType), "price"))
                    .stream()
                    .map(model -> ModelMapper.toOutputDto(model))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new InvalidSortTypeException("Должен быть ASC или DESC");
        }
    }
}
