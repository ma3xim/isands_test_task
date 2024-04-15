package ru.isands.task.services.searchAndFilters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isands.task.models.Computer;
import ru.isands.task.repositories.ComputerRepository;

import java.util.List;

@Service
public class ComputerSearchAndFilter {
    private final ComputerRepository computerRepository;

    @Autowired
    public ComputerSearchAndFilter(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    public List<Computer> search(
            String name,
            String color,
            Double minPrice,
            Double maxPrice,
            String category,
            String processorType
    ) {
        List<Computer> computers = computerRepository.findAllByTypeOfDevice("Компьютер");


        if (name != null) {
            computers.retainAll(computerRepository.findAllByNameIgnoreCase(name));
        }
        if (color != null) {
            computers.retainAll(computerRepository.findAllByColorIgnoreCase(color));
        }
        if (minPrice != null || maxPrice != null) {
            if (minPrice == null) {
                minPrice = (double) 0;
            }
            if (maxPrice == null) {
                maxPrice = (double) Integer.MAX_VALUE;
            }
            computers.retainAll(computerRepository.findAllByPriceBetween(minPrice, maxPrice));
        }
        if (category != null) {
            computers.retainAll(computerRepository.findAllByCategoryIgnoreCase(category));
        }
        if (processorType != null) {
            computers.retainAll(computerRepository.findAllByProcessorTypeIgnoreCase(processorType));
        }
        return computers;
    }
}
