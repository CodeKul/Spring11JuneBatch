package com.codekul.Spring11JuneBatch.jpa.model;

import javax.persistence.*;

@Entity
public class VehicleTypeBrandMapping {
    @EmbeddedId
    private VehicleTypeBrandMappingId mappingId;

    @ManyToOne
    @MapsId("vehicle_type_id")
    @JoinColumn(name = "vehicle_type_id")
    private VehicleType vehicleType;

    @ManyToOne
    @MapsId("brand_id")
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
