package com.codekul.Spring11JuneBatch.mongo.repository;

import com.codekul.Spring11JuneBatch.mongo.domain.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address,String> {
}
