package ru.isands.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.task.dto.outputDto.ComputerOutputDTO;
import ru.isands.task.mapper.ComputerMapper;
import ru.isands.task.models.Computer;
import ru.isands.task.models.Device;
import ru.isands.task.repositories.ComputerRepository;
import ru.isands.task.repositories.DeviceRepository;
import ru.isands.task.services.searchAndFilters.ComputerSearchAndFilter;
import ru.isands.task.util.exceptions.EntityNotValidException;
import ru.isands.task.util.exceptions.InvalidSortTypeException;
import ru.isands.task.util.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ComputerService {
    private final ComputerRepository computerRepository;
    private final DeviceRepository deviceRepository;
    private final ComputerSearchAndFilter computerSearchAndFilter;
    private final String DEVICE_TYPE = "Компьютер";

    @Autowired
    public ComputerService(ComputerRepository computerRepository, DeviceRepository deviceRepository, ComputerSearchAndFilter computerSearchAndFilter) {
        this.computerRepository = computerRepository;
        this.deviceRepository = deviceRepository;
        this.computerSearchAndFilter = computerSearchAndFilter;
    }

    public List<ComputerOutputDTO> findAllComputers() {
        return computerRepository.findAllByTypeOfDevice(DEVICE_TYPE).stream().map(comp -> ComputerMapper.toOutputDto(comp)).collect(Collectors.toList());
    }

    @Transactional
    public void save(Integer deviceId, Computer computer) {
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new NotFoundException("Техника с таким ID не найдена"));
        if (!device.getName().equals(DEVICE_TYPE)) {
            throw new EntityNotValidException("Несовместимая модель и тип техники");
        }
        computer.setDevice(device);
        computer.setTypeOfDevice(DEVICE_TYPE);
        computerRepository.save(computer);
    }

    @Transactional
    public void delete(Integer id) {
        if (computerRepository.findById(id).isEmpty()) {
            throw new EntityNotValidException(DEVICE_TYPE + " с таким ID отсутствует");
        }
        if (!computerRepository.findById(id).get().getTypeOfDevice().equals(DEVICE_TYPE)) {
            throw new EntityNotValidException("Эта техника не " + DEVICE_TYPE);
        }
        computerRepository.deleteById(id);
    }


    public List<ComputerOutputDTO> getWithSearch(
            String name,
            String color,
            Double minPrice,
            Double maxPrice,
            String category,
            String processorType
    ) {
        List<Computer> computers = computerSearchAndFilter.search(name, color, minPrice, maxPrice, category, processorType);

        return computers.stream()
                .map(comp -> ComputerMapper.toOutputDto(comp))
                .collect(Collectors.toList());
    }

    public List<ComputerOutputDTO> sortByName(String sortType) {
        try {
            return computerRepository.findAllByTypeOfDevice(DEVICE_TYPE, Sort.by(Sort.Direction.fromString(sortType), "name"))
                    .stream()
                    .map(comp -> ComputerMapper.toOutputDto(comp))
                    .collect(Collectors.toList());
        }
        catch (IllegalArgumentException e){
            throw new InvalidSortTypeException("Должен быть ASC или DESC");
        }
    }

    public List<ComputerOutputDTO> sortByPrice(String sortType) {
        try {
            return computerRepository.findAllByTypeOfDevice(DEVICE_TYPE, Sort.by(Sort.Direction.fromString(sortType), "price"))
                    .stream()
                    .map(comp -> ComputerMapper.toOutputDto(comp))
                    .collect(Collectors.toList());
        }
        catch (IllegalArgumentException e){
            throw new InvalidSortTypeException("Должен быть ASC или DESC");
        }
    }
}
