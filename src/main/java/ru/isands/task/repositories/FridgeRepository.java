package ru.isands.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isands.task.models.Fridge;

import java.util.List;

@Repository
public interface FridgeRepository extends JpaRepository<Fridge, Integer>, ModelInterface<Fridge> {

    List<Fridge> findAllByDoorsBetween(Integer minDoors, Integer maxDoors);

    List<Fridge> findAllByCompressorTypeIgnoreCase(String type);
}
