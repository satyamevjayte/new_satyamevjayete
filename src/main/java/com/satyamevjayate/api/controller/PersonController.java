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
    private PersonServices personServices;
    @GetMapping("/person")
    public List<Person> getAllPerson() {
        return personServices.listAllPerson();
    }
    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Long id)
    {
        Person Person= personServices.getPerson(id);
        return Person;
    }
    @PostMapping("/person")
    public String addPerson(@RequestBody Person Person)
    {
        personServices.savePerson(Person);;
        return "Person Add Successfully";
    }
    @DeleteMapping("/person/{id}")
    public String deletePerson(@PathVariable Long id)
    {
        personServices.deletePerson(id);
        return "Delete Person Successfully";
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Object> editPerson(@RequestBody Person Person, @PathVariable Long id) {
        Person.setPersonId(id);;
        personServices.savePerson(Person);
        return ResponseEntity.noContent().build();
    }

}