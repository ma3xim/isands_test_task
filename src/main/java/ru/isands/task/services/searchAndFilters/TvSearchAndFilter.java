package ru.isands.task.services.searchAndFilters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isands.task.models.Tv;
import ru.isands.task.repositories.TvRepository;

import java.util.List;

@Service
public class TvSearchAndFilter {
    private final TvRepository tvRepository;

    @Autowired
    public TvSearchAndFilter(TvRepository tvRepository) {
        this.tvRepository = tvRepository;
    }

    public List<Tv> search(
            String name,
            String color,
            Double minPrice,
            Double maxPrice,
            String category,
            String technology
    ) {
        List<Tv> tvs = tvRepository.findAllByTypeOfDevice("Телевизор");

        if (name != null) {
            tvs.retainAll(tvRepository.findAllByNameIgnoreCase(name));
        }
        if (color != null) {
            tvs.retainAll(tvRepository.findAllByColorIgnoreCase(color));
        }
        if (minPrice != null || maxPrice != null) {
            if (minPrice == null) {
                minPrice = (double) 0;
            }
            if (maxPrice == null) {
                maxPrice = (double) Integer.MAX_VALUE;
            }
            tvs.retainAll(tvRepository.findAllByPriceBetween(minPrice, maxPrice));
        }
        if (category != null) {
            tvs.retainAll(tvRepository.findAllByCategoryIgnoreCase(category));
        }
        if (technology != null) {
            tvs.retainAll(tvRepository.findAllByTechnologyIgnoreCase(technology));
        }
        return tvs;
    }
}
