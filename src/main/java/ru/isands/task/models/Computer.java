package ru.isands.task.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "Model")
public class Computer extends AbstractModel{

    @Column(name = "computer_category")
    private String category;

    @Column(name = "computer_processor_type")
    private String processorType;


}
