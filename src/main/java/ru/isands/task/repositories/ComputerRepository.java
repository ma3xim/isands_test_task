package ru.isands.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isands.task.models.Computer;

import java.util.List;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Integer>, ModelInterface<Computer> {
    List<Computer> findAllByCategoryIgnoreCase(String category);

    List<Computer> findAllByProcessorTypeIgnoreCase(String processorType);

}
