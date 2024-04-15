package ru.isands.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.task.dto.outputDto.VacuumCleanerOutputDTO;
import ru.isands.task.mapper.VacuumCleanerMapper;
import ru.isands.task.models.Device;
import ru.isands.task.models.VacuumCleaner;
import ru.isands.task.repositories.DeviceRepository;
import ru.isands.task.repositories.VacuumCleanerRepository;
import ru.isands.task.services.searchAndFilters.VacuumCleanerSearchAndFilter;
import ru.isands.task.util.exceptions.EntityNotValidException;
import ru.isands.task.util.exceptions.InvalidSortTypeException;
import ru.isands.task.util.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class VacuumCleanerService {
    private final VacuumCleanerRepository vacuumCleanerRepository;
    private final DeviceRepository deviceRepository;
    private final VacuumCleanerSearchAndFilter vacuumCleanerSearchAndFilter;
    private final String DEVICE_TYPE = "Пылесос";

    @Autowired
    public VacuumCleanerService(VacuumCleanerRepository vacuumCleanerRepository, DeviceRepository deviceRepository, VacuumCleanerSearchAndFilter vacuumCleanerSearchAndFilter) {
        this.vacuumCleanerRepository = vacuumCleanerRepository;
        this.deviceRepository = deviceRepository;
        this.vacuumCleanerSearchAndFilter = vacuumCleanerSearchAndFilter;
    }

    public List<VacuumCleanerOutputDTO> findAllCVacuumCleaners() {
        return vacuumCleanerRepository.findAllByTypeOfDevice(DEVICE_TYPE).stream().map(cleaner -> VacuumCleanerMapper.toOutputDto(cleaner)).collect(Collectors.toList());
    }

    @Transactional
    public void save(Integer deviceId, VacuumCleaner vacuumCleaner) {
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new NotFoundException("Техника с таким ID не найдена"));
        if (!device.getName().equals(DEVICE_TYPE)) {
            throw new EntityNotValidException("Несовместимая модель и тип техники");
        }
        vacuumCleaner.setDevice(device);
        vacuumCleaner.setTypeOfDevice(DEVICE_TYPE);
        vacuumCleanerRepository.save(vacuumCleaner);
    }

    @Transactional
    public void delete(Integer id) {
        if (vacuumCleanerRepository.findById(id).isEmpty()) {
            throw new EntityNotValidException(DEVICE_TYPE + " с таким ID отсутствует");
        }
        if (!vacuumCleanerRepository.findById(id).get().getTypeOfDevice().equals(DEVICE_TYPE)) {
            throw new EntityNotValidException("Эта техника не " + DEVICE_TYPE);
        }
        vacuumCleanerRepository.deleteById(id);
    }


    public List<VacuumCleanerOutputDTO> getWithSearch(
            String name,
            String color,
            Double minPrice,
            Double maxPrice,
            Integer minCapacity,
            Integer maxCapacity,
            Integer minModes,
            Integer maxModes
    ) {
        List<VacuumCleaner> vacuumCleaners = vacuumCleanerSearchAndFilter.search(name, color, minPrice, maxPrice, minCapacity, maxCapacity, minModes, maxModes);

        return vacuumCleaners.stream()
                .map(cleaner -> VacuumCleanerMapper.toOutputDto(cleaner))
                .collect(Collectors.toList());
    }

    public List<VacuumCleanerOutputDTO> sortByName(String sortType) {
        try {
            return vacuumCleanerRepository.findAllByTypeOfDevice(DEVICE_TYPE, Sort.by(Sort.Direction.fromString(sortType), "name"))
                    .stream()
                    .map(cleaner -> VacuumCleanerMapper.toOutputDto(cleaner))
                    .collect(Collectors.toList());
        }
        catch (IllegalArgumentException e){
            throw new InvalidSortTypeException("Должен быть ASC или DESC");
        }
    }

    public List<VacuumCleanerOutputDTO> sortByPrice(String sortType) {
        try {
            return vacuumCleanerRepository.findAllByTypeOfDevice(DEVICE_TYPE, Sort.by(Sort.Direction.fromString(sortType), "price"))
                    .stream()
                    .map(cleaner -> VacuumCleanerMapper.toOutputDto(cleaner))
                    .collect(Collectors.toList());
        }
        catch (IllegalArgumentException e){
            throw new InvalidSortTypeException("Должен быть ASC или DESC");
        }
    }
}
