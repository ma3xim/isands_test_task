package ru.isands.task.services.searchAndFilters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isands.task.models.Model;
import ru.isands.task.repositories.ModelRepository;

import java.util.List;

@Service
public class ModelsSearchAndFilter {
    private final ModelRepository modelRepository;

    @Autowired
    public ModelsSearchAndFilter(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public List<Model> search(
            String name,
            String color,
            Double minPrice,
            Double maxPrice
    ) {
        List<Model> models = modelRepository.findAll();

        if (name != null) {
            models.retainAll(modelRepository.findAllByNameIgnoreCase(name));
        }
        if (color != null) {
            models.retainAll(modelRepository.findAllByColorIgnoreCase(color));
        }

        if (minPrice != null || maxPrice != null) {
            if (minPrice == null) {
                minPrice = (double) 0;
            }
            if (maxPrice == null) {
                maxPrice = (double) Integer.MAX_VALUE;
            }
            models.retainAll(modelRepository.findAllByPriceBetween(minPrice, maxPrice));
        }
        return models;
    }
}
