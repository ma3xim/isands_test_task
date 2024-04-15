package ru.isands.task.services.searchAndFilters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isands.task.models.Fridge;
import ru.isands.task.repositories.FridgeRepository;

import java.util.List;

@Service
public class FridgeSearchAndFilter {
    private final FridgeRepository fridgeRepository;

    @Autowired
    public FridgeSearchAndFilter(FridgeRepository fridgeRepository) {
        this.fridgeRepository = fridgeRepository;
    }

    public List<Fridge> search(
            String name,
            String color,
            Double minPrice,
            Double maxPrice,
            Integer minDoors,
            Integer maxDoors,
            String compressorType
    ) {
        List<Fridge> fridges = fridgeRepository.findAllByTypeOfDevice("Холодильник");


        if (name != null) {
            fridges.retainAll(fridgeRepository.findAllByNameIgnoreCase(name));
        }
        if (color != null) {
            fridges.retainAll(fridgeRepository.findAllByColorIgnoreCase(color));
        }
        if (minPrice != null || maxPrice != null) {
            if (minPrice == null) {
                minPrice = (double) 0;
            }
            if (maxPrice == null) {
                maxPrice = (double) Integer.MAX_VALUE;
            }
            fridges.retainAll(fridgeRepository.findAllByPriceBetween(minPrice, maxPrice));
        }
        if (minDoors != null || maxDoors!=null) {
            if (minDoors == null) {
                minDoors = 0;
            }
            if (maxDoors == null) {
                maxDoors = Integer.MAX_VALUE;
            }
            fridges.retainAll(fridgeRepository.findAllByDoorsBetween(minDoors, maxDoors));
        }
        if (compressorType != null) {
            fridges.retainAll(fridgeRepository.findAllByCompressorTypeIgnoreCase(compressorType));
        }
        return fridges;
    }
}
