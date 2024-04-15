package ru.isands.task.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Data
@AllArgsConstructor
@Table(name = "Model")
@EqualsAndHashCode(callSuper = true)
public class Model extends AbstractModel{


}
