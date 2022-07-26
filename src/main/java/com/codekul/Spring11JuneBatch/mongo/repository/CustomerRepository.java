package com.codekul.Spring11JuneBatch.mongo.repository;

import com.codekul.Spring11JuneBatch.mongo.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer,String> {
    List<Customer> findByCity(String city);

    @Query("{ $and:[{city:?0},{contactNo:?1}]}")
    Optional<Customer> findByCityAndContactNo(String city, String contactNo);

    @Query("{ $or:[{city:?0},{contactNo:?0},{customerName:?0}]}")
    Optional<List<Customer>> findByCityOrContactNoOrCustomerName(String searchString);
}
