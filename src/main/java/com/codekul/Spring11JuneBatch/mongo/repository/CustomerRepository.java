package com.codekul.Spring11JuneBatch.mongo.repository;

import com.codekul.Spring11JuneBatch.mongo.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer,String> {
    List<Customer> findByCity(String city);
}
