package ru.isands.task.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Model")
@EqualsAndHashCode(callSuper = true)
public class Model extends AbstractModel{


}
