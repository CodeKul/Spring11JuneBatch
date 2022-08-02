package com.codekul.Spring11JuneBatch.mongo.repository;

import com.codekul.Spring11JuneBatch.mongo.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person,String> {
}
