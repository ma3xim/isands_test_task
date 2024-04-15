package ru.isands.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isands.task.models.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer>, ModelInterface<Model> {

}
