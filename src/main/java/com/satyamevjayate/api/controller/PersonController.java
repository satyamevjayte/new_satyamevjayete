package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
@RestController
public class PersonController {
    @Autowired
    private PersonServices Person_Services;
    @GetMapping("/GetAllPerson")
    public List<Person> getAllPerson() {
        return Person_Services.listAllPerson();
    }
    @GetMapping("/GetPerson/{id}")
    public Person getPerson(@PathVariable BigInteger id)
    {
        Person Person= Person_Services.getPerson(id);
        return Person;
    }
    @PostMapping("/AddPerson")
    public String addPerson(@RequestBody Person Person)
    {
        Person_Services.savePerson(Person);;
        return "Person Add Successfully";
    }
    @DeleteMapping("/DeletePerson/{id}")
    public String deletePerson(@PathVariable BigInteger id)
    {
        Person_Services.deletePerson(id);
        return "Delete Person Successfully";
    }

    @PutMapping("/EditPerson/{id}")
    public ResponseEntity<Object> editPerson(@RequestBody Person Person, @PathVariable BigInteger id) {
        Person.setPersonId(id);;
        Person_Services.savePerson(Person);
        return ResponseEntity.noContent().build();
    }

}