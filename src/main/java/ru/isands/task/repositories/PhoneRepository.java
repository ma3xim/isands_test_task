package ru.isands.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isands.task.models.Phone;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> , ModelInterface<Phone> {
    List<Phone> findAllByCamerasBetween(Integer minCameras, Integer maxCameras);

    List<Phone> findAllByMemoryBetween(Integer minMemory, Integer maxMemory);
}
