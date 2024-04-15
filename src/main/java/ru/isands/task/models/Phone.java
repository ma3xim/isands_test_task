package ru.isands.task.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "Model")
public class Phone extends AbstractModel{

    @Column(name = "phone_memory")
    private Integer memory;

    @Column(name = "phone_cameras")
    private Integer cameras;

}
