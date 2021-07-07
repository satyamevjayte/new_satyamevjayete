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
    private PersonRepository person_repository;

    public List<Person> listAllPerson()
    {
        return person_repository.findAll();
    }

    public void savePerson(Person Person)
    {
        person_repository.save(Person);
    }

    public Person getPerson(BigInteger Id)
    {
        return person_repository.findById(Id).get();
    }

    public void deletePerson(BigInteger Id)
    {
        person_repository.deleteById(Id);
    }
}
