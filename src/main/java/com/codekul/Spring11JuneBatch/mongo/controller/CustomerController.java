package com.codekul.Spring11JuneBatch.mongo.controller;

import com.codekul.Spring11JuneBatch.mongo.domain.Customer;
import com.codekul.Spring11JuneBatch.mongo.repository.CustomerRepository;
import com.codekul.Spring11JuneBatch.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.codekul.Spring11JuneBatch.util.Constants.MESSAGE;
import static com.codekul.Spring11JuneBatch.util.Constants.STATUS;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    private Map<String, Object> map = new HashMap<>();

    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        map.clear();
        Customer customer1 = customerRepository.save(customer);
        map.put("customer", customer1);
        map.put(STATUS, 200);
        map.put(MESSAGE, "Customer saved Successfully");
        return ResponseEntity.ok(map);
    }

    @GetMapping("/getCustomerByCity")
    public ResponseEntity<?> getCustomerByCity(@RequestParam String city) {
        map.clear();
        map.put("customers", customerRepository.findByCity(city));
        map.put(STATUS, 200);
        map.put(MESSAGE, "Get customer ");
        return ResponseEntity.ok(map);
    }

    @GetMapping("/getCustomerByCityAndContactNo/{city}/{contactNo}")
    public ResponseEntity<?> getCustomerByCityAndContactNo(@PathVariable String city,
                                                           @PathVariable String contactNo) {
        map.clear();
        Optional<Customer> customerOptional = customerRepository.findByCityAndContactNo(city, contactNo);
        if (customerOptional.isPresent()) {
            map.put("customers", customerOptional.get());
            map.put(STATUS, 200);
            map.put(MESSAGE, "Get customer by city and contact no ");
            return ResponseEntity.ok(map);

        } else {
            map.put(STATUS, HttpStatus.NOT_FOUND.value());
            map.put(MESSAGE, "No customer found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getCustomer")
    public ResponseEntity<?> findCustomer(@RequestParam String searchString) {
        map.clear();
        Optional<List<Customer>> customerOptional = customerRepository.findByCityOrContactNoOrCustomerName(searchString);
        if (customerOptional.isPresent()) {
            map.put("customers", customerOptional.get());
            map.put(STATUS, 200);
            map.put(MESSAGE, "Get customer by city and contact no and name");
            return ResponseEntity.ok(map);

        } else {
            map.put(STATUS, HttpStatus.NOT_FOUND.value());
            map.put(MESSAGE, "No customer found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/searchCustomer")
    public ResponseEntity<?> searchCustomer(@RequestParam String searchString){
        ApiResponse<List<Customer>>  apiResponse = new ApiResponse<>();
        Optional<List<Customer>> customerOptional = customerRepository.searchCustomer(searchString);
        if (customerOptional.isPresent()) {
            apiResponse.setResult(customerOptional.get());
            apiResponse.setStatus(200);
            apiResponse.setMessage("search customer");
            return ResponseEntity.ok(apiResponse);

        } else {
            apiResponse.setStatus( HttpStatus.NOT_FOUND.value());
            apiResponse.setMessage("No customer found");
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
    }
}
