package ru.isands.task.services.searchAndFilters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isands.task.models.Phone;
import ru.isands.task.repositories.PhoneRepository;

import java.util.List;

@Service
public class PhoneSearchAndFilter {
    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneSearchAndFilter(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public List<Phone> search(
            String name,
            String color,
            Double minPrice,
            Double maxPrice,
            Integer minCameras,
            Integer maxCameras,
            Integer minMemory,
            Integer maxMemory
    ) {
        List<Phone> phones = phoneRepository.findAllByTypeOfDevice("Смартфон");


        if (name != null) {
            phones.retainAll(phoneRepository.findAllByNameIgnoreCase(name));
        }
        if (color != null) {
            phones.retainAll(phoneRepository.findAllByColorIgnoreCase(color));
        }
        if (minPrice != null || maxPrice != null) {
            if (minPrice == null) {
                minPrice = (double) 0;
            }
            if (maxPrice == null) {
                maxPrice = (double) Integer.MAX_VALUE;
            }
            phones.retainAll(phoneRepository.findAllByPriceBetween(minPrice, maxPrice));
        }
        if (minCameras != null || maxCameras!=null) {
            if (minCameras == null) {
                minCameras = 0;
            }
            if (maxCameras == null) {
                maxCameras = Integer.MAX_VALUE;
            }
            phones.retainAll(phoneRepository.findAllByCamerasBetween(minCameras, maxCameras));
        }
        if (minMemory != null || maxMemory!=null) {
            if (minMemory == null) {
                minMemory = 0;
            }
            if (maxMemory == null) {
                maxMemory = Integer.MAX_VALUE;
            }
            phones.retainAll(phoneRepository.findAllByMemoryBetween(minMemory, maxMemory));
        }
        return phones;
    }
}
