package com.codekul.Spring11JuneBatch.mongo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@Document(collection = "address")
public class Address {
    @Id
    private String id;
    private String area;
    private String landmark;
    private String pinCode;
    private String city;
    private String addressType;
}
