package ru.isands.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.task.dto.outputDto.FridgeOutputDTO;
import ru.isands.task.mapper.FridgeMapper;
import ru.isands.task.models.Device;
import ru.isands.task.models.Fridge;
import ru.isands.task.repositories.DeviceRepository;
import ru.isands.task.repositories.FridgeRepository;
import ru.isands.task.services.searchAndFilters.FridgeSearchAndFilter;
import ru.isands.task.util.exceptions.EntityNotValidException;
import ru.isands.task.util.exceptions.InvalidSortTypeException;
import ru.isands.task.util.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class FridgeService {
    private final FridgeRepository fridgeRepository;
    private final DeviceRepository deviceRepository;
    private final FridgeSearchAndFilter fridgeSearchAndFilter;
    private final String DEVICE_TYPE = "Холодильник";

    @Autowired
    public FridgeService(FridgeRepository fridgeRepository, DeviceRepository deviceRepository, FridgeSearchAndFilter fridgeSearchAndFilter) {
        this.fridgeRepository = fridgeRepository;
        this.deviceRepository = deviceRepository;
        this.fridgeSearchAndFilter = fridgeSearchAndFilter;
    }

    public List<FridgeOutputDTO> findAllFridges() {
        return fridgeRepository.findAllByTypeOfDevice(DEVICE_TYPE).stream().map(fridge -> FridgeMapper.toOutputDto(fridge)).collect(Collectors.toList());
    }

    @Transactional
    public void save(Integer deviceId, Fridge fridge) {
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new NotFoundException("Техника с таким ID не найдена"));
        if (!device.getName().equals(DEVICE_TYPE)) {
            throw new EntityNotValidException("Несовместимая модель и тип техники");
        }
        fridge.setDevice(device);
        fridge.setTypeOfDevice(DEVICE_TYPE);
        fridgeRepository.save(fridge);
    }

    @Transactional
    public void delete(Integer id) {
        if (fridgeRepository.findById(id).isEmpty()) {
            throw new EntityNotValidException(DEVICE_TYPE + " с таким ID отсутствует");
        }
        if (!fridgeRepository.findById(id).get().getTypeOfDevice().equals(DEVICE_TYPE)) {
            throw new EntityNotValidException("Эта техника не " + DEVICE_TYPE);
        }
        fridgeRepository.deleteById(id);
    }

    public List<FridgeOutputDTO> getWithSearch(
            String name,
            String color,
            Double minPrice,
            Double maxPrice,
            Integer minDoors,
            Integer maxDoors,
            String compressorType
    ) {
        List<Fridge> fridges = fridgeSearchAndFilter.search(name, color, minPrice, maxPrice, minDoors, maxDoors, compressorType);

        return fridges.stream()
                .map(fridge -> FridgeMapper.toOutputDto(fridge))
                .collect(Collectors.toList());
    }

    public List<FridgeOutputDTO> sortByName(String sortType) {
        try {
            return fridgeRepository.findAllByTypeOfDevice(DEVICE_TYPE, Sort.by(Sort.Direction.fromString(sortType), "name"))
                    .stream()
                    .map(fridge -> FridgeMapper.toOutputDto(fridge))
                    .collect(Collectors.toList());
        }
        catch (IllegalArgumentException e){
            throw new InvalidSortTypeException("Должен быть ASC или DESC");
        }
    }

    public List<FridgeOutputDTO> sortByPrice(String sortType) {
        try {
            return fridgeRepository.findAllByTypeOfDevice(DEVICE_TYPE, Sort.by(Sort.Direction.fromString(sortType), "price"))
                    .stream()
                    .map(fridge -> FridgeMapper.toOutputDto(fridge))
                    .collect(Collectors.toList());
        }
        catch (IllegalArgumentException e){
            throw new InvalidSortTypeException("Должен быть ASC или DESC");
        }
    }
}
