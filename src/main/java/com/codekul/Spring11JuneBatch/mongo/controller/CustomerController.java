package com.codekul.Spring11JuneBatch.mongo.controller;

import com.codekul.Spring11JuneBatch.mongo.domain.Customer;
import com.codekul.Spring11JuneBatch.mongo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codekul.Spring11JuneBatch.util.Constants.MESSAGE;
import static com.codekul.Spring11JuneBatch.util.Constants.STATUS;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    Map<String,Object> map = new HashMap<>();
    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
        map.clear();
        Customer customer1 = customerRepository.save(customer);
        map.put("customer",customer1);
        map.put(STATUS,200);
        map.put(MESSAGE,"Customer saved Successfully");
        return ResponseEntity.ok(map);
    }

    @GetMapping("/getCustomerByCity")
    public ResponseEntity<?> getCustomerByCity(@RequestParam String city){
        map.clear();
        map.put("customers",customerRepository.findByCity(city));
        map.put(STATUS,200);
        map.put(MESSAGE,"Get customer ");
        return ResponseEntity.ok(map);
    }
}
