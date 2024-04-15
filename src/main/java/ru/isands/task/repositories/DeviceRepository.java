package ru.isands.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isands.task.models.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
