package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class PersonServices {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> listAllPerson()
    {
        return personRepository.findAll();
    }

    public void savePerson(Person Person)
    {
        personRepository.save(Person);
    }

    public Person getPerson(Long Id)
    {
        return personRepository.findById(Id).get();
    }

    public void deletePerson(Long Id)
    {
        personRepository.deleteById(Id);
    }
}
