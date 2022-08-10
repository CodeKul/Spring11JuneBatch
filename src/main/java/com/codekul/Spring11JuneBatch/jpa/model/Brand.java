package com.codekul.Spring11JuneBatch.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String brand;
    @Transient
    private List<VehicleType> vehicleType;
}
