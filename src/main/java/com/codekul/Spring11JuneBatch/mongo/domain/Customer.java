package com.codekul.Spring11JuneBatch.mongo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customer")
public class Customer {
    @Id
    private String id;
    @TextIndexed
    private String customerName;
    private String contactNo;
    @TextIndexed
    private String city;
    private String address;
}
