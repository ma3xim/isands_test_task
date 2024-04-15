package ru.isands.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isands.task.models.Tv;

import java.util.List;

@Repository
public interface TvRepository extends JpaRepository<Tv, Integer>, ModelInterface<Tv> {
    List<Tv> findAllByCategoryIgnoreCase(String category);

    List<Tv> findAllByTechnologyIgnoreCase(String technology);
}
