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
public class VacuumCleaner extends AbstractModel{

    @Column(name = "vacuum_cleaner_dust_bag_capacity")
    private Integer dustBagCapacity;

    @Column(name = "vacuum_cleaner_modes")
    private Integer cleanerModes;
}
