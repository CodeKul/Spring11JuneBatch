package com.codekul.Spring11JuneBatch.jpa.controller;

import com.codekul.Spring11JuneBatch.jpa.model.VehicleType;
import com.codekul.Spring11JuneBatch.jpa.repository.VehicleTypeRepository;
import com.codekul.Spring11JuneBatch.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicletype")
public class VehicleTypeController {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;
    @PostMapping
    public ResponseEntity<?> saveVehicleType(@RequestBody VehicleType vehicleType){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("vehicle type saved successfully");
        apiResponse.setStatus(HttpStatus.OK.value());
        vehicleTypeRepository.save(vehicleType);
        return ResponseEntity.ok(apiResponse);
    }
}
