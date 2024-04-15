package ru.isands.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.task.dto.outputDto.PhoneOutputDTO;
import ru.isands.task.mapper.PhoneMapper;
import ru.isands.task.models.Device;
import ru.isands.task.models.Phone;
import ru.isands.task.repositories.DeviceRepository;
import ru.isands.task.repositories.PhoneRepository;
import ru.isands.task.services.searchAndFilters.PhoneSearchAndFilter;
import ru.isands.task.util.exceptions.EntityNotValidException;
import ru.isands.task.util.exceptions.InvalidSortTypeException;
import ru.isands.task.util.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class PhoneService {
    private final PhoneRepository phoneRepository;
    private final DeviceRepository deviceRepository;
    private final PhoneSearchAndFilter phoneSearchAndFilter;
    private final String DEVICE_TYPE = "Смартфон";

    @Autowired
    public PhoneService(PhoneRepository phoneRepository, DeviceRepository deviceRepository, PhoneSearchAndFilter phoneSearchAndFilter) {
        this.phoneRepository = phoneRepository;
        this.deviceRepository = deviceRepository;
        this.phoneSearchAndFilter = phoneSearchAndFilter;
    }

    public List<PhoneOutputDTO> findAllPhones() {
        return phoneRepository.findAllByTypeOfDevice(DEVICE_TYPE).stream().map(phone -> PhoneMapper.toOutputDto(phone)).collect(Collectors.toList());
    }

    @Transactional
    public void save(Integer deviceId, Phone phone) {
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new NotFoundException("Техника с таким ID не найдена"));
        if (!device.getName().equals(DEVICE_TYPE)) {
            throw new EntityNotValidException("Несовместимая модель и тип техники");
        }
        phone.setDevice(device);
        phone.setTypeOfDevice(DEVICE_TYPE);
        phoneRepository.save(phone);
    }

    @Transactional
    public void delete(Integer id) {
        if (phoneRepository.findById(id).isEmpty()) {
            throw new EntityNotValidException(DEVICE_TYPE + " с таким ID отсутствует");
        }
        if (!phoneRepository.findById(id).get().getTypeOfDevice().equals(DEVICE_TYPE)) {
            throw new EntityNotValidException("Эта техника не " + DEVICE_TYPE);
        }
        phoneRepository.deleteById(id);
    }


    public List<PhoneOutputDTO> getWithSearch(
            String name,
            String color,
            Double minPrice,
            Double maxPrice,
            Integer minCameras,
            Integer maxCameras,
            Integer minMemory,
            Integer maxMemory
    ) {
        List<Phone> phones = phoneSearchAndFilter.search(name, color, minPrice, maxPrice, minCameras, maxCameras, minMemory,maxMemory);

        return phones.stream()
                .map(phone -> PhoneMapper.toOutputDto(phone))
                .collect(Collectors.toList());
    }

    public List<PhoneOutputDTO> sortByName(String sortType) {
        try {
            return phoneRepository.findAllByTypeOfDevice(DEVICE_TYPE, Sort.by(Sort.Direction.fromString(sortType), "name"))
                    .stream()
                    .map(phone -> PhoneMapper.toOutputDto(phone))
                    .collect(Collectors.toList());
        }
        catch (IllegalArgumentException e){
            throw new InvalidSortTypeException("Должен быть ASC или DESC");
        }
    }

    public List<PhoneOutputDTO> sortByPrice(String sortType) {
        try {
            return phoneRepository.findAllByTypeOfDevice(DEVICE_TYPE, Sort.by(Sort.Direction.fromString(sortType), "price"))
                    .stream()
                    .map(phone -> PhoneMapper.toOutputDto(phone))
                    .collect(Collectors.toList());
        }
        catch (IllegalArgumentException e){
            throw new InvalidSortTypeException("Должен быть ASC или DESC");
        }
    }
}
