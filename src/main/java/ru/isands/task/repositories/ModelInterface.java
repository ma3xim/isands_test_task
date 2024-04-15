package ru.isands.task.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ModelInterface<T> {
    List<T> findAllByTypeOfDevice(String type);

    List<T> findAllByTypeOfDevice(String type, Sort sort);

    List<T> findAllByPriceBetween(Double min, Double max);

    List<T> findAllByColorIgnoreCase(String color);

    List<T> findAllByNameIgnoreCase(String name);

}
