package ru.isands.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isands.task.models.Fridge;
import ru.isands.task.models.VacuumCleaner;

import java.util.List;

@Repository
public interface VacuumCleanerRepository extends JpaRepository<VacuumCleaner, Integer>, ModelInterface<VacuumCleaner> {
    List<VacuumCleaner> findAllByDustBagCapacityBetween(Integer minCapacity, Integer maxCapacity);

    List<VacuumCleaner> findAllByCleanerModesBetween(Integer minModes, Integer maxModes);
}
