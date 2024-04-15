package ru.isands.task.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "Model")
public class Fridge extends AbstractModel{

    @Column(name = "fridge_doors")
    private Integer doors;

    @Column(name = "fridge_compressor_type")
    private String compressorType;
}
