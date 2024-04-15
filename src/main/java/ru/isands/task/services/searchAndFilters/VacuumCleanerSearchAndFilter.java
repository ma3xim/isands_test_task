package ru.isands.task.services.searchAndFilters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isands.task.models.VacuumCleaner;
import ru.isands.task.repositories.VacuumCleanerRepository;

import java.util.List;

@Service
public class VacuumCleanerSearchAndFilter {
    private final VacuumCleanerRepository vacuumCleanerRepository;

    @Autowired
    public VacuumCleanerSearchAndFilter(VacuumCleanerRepository vacuumCleanerRepository) {
        this.vacuumCleanerRepository = vacuumCleanerRepository;
    }

    public List<VacuumCleaner> search(
            String name,
            String color,
            Double minPrice,
            Double maxPrice,
            Integer minCapacity,
            Integer maxCapacity,
            Integer minModes,
            Integer maxModes
    ) {
        List<VacuumCleaner> vacuumCleaners = vacuumCleanerRepository.findAllByTypeOfDevice("Пылесос");


        if (name != null) {
            vacuumCleaners.retainAll(vacuumCleanerRepository.findAllByNameIgnoreCase(name));
        }
        if (color != null) {
            vacuumCleaners.retainAll(vacuumCleanerRepository.findAllByColorIgnoreCase(color));
        }
        if (minPrice != null || maxPrice != null) {
            if (minPrice == null) {
                minPrice = (double) 0;
            }
            if (maxPrice == null) {
                maxPrice = (double) Integer.MAX_VALUE;
            }
            vacuumCleaners.retainAll(vacuumCleanerRepository.findAllByPriceBetween(minPrice, maxPrice));
        }
        if (minCapacity != null || maxCapacity != null) {
            if (minCapacity == null) {
                minCapacity =  0;
            }
            if (maxCapacity == null) {
                maxCapacity =  Integer.MAX_VALUE;
            }
            vacuumCleaners.retainAll(vacuumCleanerRepository.findAllByDustBagCapacityBetween(minCapacity, maxCapacity));
        }
        if (minModes != null || maxModes!=null) {
            if (minModes == null) {
                minModes =  0;
            }
            if (maxModes == null) {
                maxModes =  Integer.MAX_VALUE;
            }
            vacuumCleaners.retainAll(vacuumCleanerRepository.findAllByCleanerModesBetween(minModes, maxModes));
        }
        return vacuumCleaners;
    }
}
