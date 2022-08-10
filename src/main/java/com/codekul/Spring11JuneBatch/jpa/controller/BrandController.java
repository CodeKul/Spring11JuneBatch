package com.codekul.Spring11JuneBatch.jpa.controller;

import com.codekul.Spring11JuneBatch.jpa.model.Brand;
import com.codekul.Spring11JuneBatch.jpa.model.VehicleTypeBrandMapping;
import com.codekul.Spring11JuneBatch.jpa.model.VehicleTypeBrandMappingId;
import com.codekul.Spring11JuneBatch.jpa.repository.BrandRepository;
import com.codekul.Spring11JuneBatch.jpa.repository.VehicleTypeBrandMappingRepository;
import com.codekul.Spring11JuneBatch.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/brand")
@RestController
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private VehicleTypeBrandMappingRepository vehicleTypeBrandMappingRepository;

    @PostMapping("/saveBrand")
    public ResponseEntity<?> saveBrand(@RequestBody Brand brand) {
        ApiResponse<Void> apiResponse = new ApiResponse<>();
        Brand brand1 = brandRepository.save(brand);
        brand.getVehicleType()
                .forEach(vehicleType -> {
                    VehicleTypeBrandMappingId mappingId = new VehicleTypeBrandMappingId();
                    mappingId.setBrandId(brand1.getId());
                    mappingId.setVehicleTypeId(vehicleType.getId());
                    VehicleTypeBrandMapping vehicleTypeBrandMapping = new VehicleTypeBrandMapping();
                    vehicleTypeBrandMapping.setMappingId(mappingId);
                    vehicleTypeBrandMappingRepository.save(vehicleTypeBrandMapping);

                });
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setMessage("Brand successfully");
        brandRepository.save(brand);
        return ResponseEntity.ok(apiResponse);
    }
}
