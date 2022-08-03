package com.codekul.Spring11JuneBatch.mongo.controller;

import com.codekul.Spring11JuneBatch.mongo.domain.Person;
import com.codekul.Spring11JuneBatch.mongo.dto.SendMailContent;
import com.codekul.Spring11JuneBatch.mongo.repository.AddressRepository;
import com.codekul.Spring11JuneBatch.mongo.repository.PersonRepository;
import com.codekul.Spring11JuneBatch.sendemail.SendMail;
import com.codekul.Spring11JuneBatch.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private SendMail sendMail;

    @PostMapping
    public ResponseEntity<?> savePerson(@RequestBody Person person) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(HttpStatus.OK.value());
        addressRepository.saveAll(person.getAddressList());
        personRepository.save(person);
        apiResponse.setMessage("Person Saved successfully");
        personRepository.save(person);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAllPerson(){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setMessage("Person Saved successfully");
        apiResponse.setResult(personRepository.findAll());
        return ResponseEntity.ok(apiResponse);
    }
    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(@RequestBody SendMailContent content){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setMessage("Sending an Email");
        apiResponse.setResult(sendMail.sendMail(content.getTo(),
                content.getSubject(), content.getContent()));
        return ResponseEntity.ok(apiResponse);
    }
}
