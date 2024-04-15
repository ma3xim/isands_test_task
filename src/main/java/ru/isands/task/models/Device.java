package ru.isands.task.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "country_manufacturer")
    private String countryManufacturer;

    @Column(name = "company_manufacturer")
    private String companyManufacturer;

    @Column(name = "is_online_order")
    private Boolean isOnlineOrder;

    @Column(name = "is_installment")
    private Boolean isInstallment;

    @OneToMany
    @JoinColumn(name = "device_id")
    private List<Model> models;


}
