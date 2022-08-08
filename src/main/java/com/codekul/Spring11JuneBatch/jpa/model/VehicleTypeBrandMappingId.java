package com.codekul.Spring11JuneBatch.jpa.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class VehicleTypeBrandMappingId implements Serializable {
    @Column(name = "brand_id")
    private Long brandId;
    @Column(name = "vehicle_type_id")
    private Long vehicleTypeId;
}
