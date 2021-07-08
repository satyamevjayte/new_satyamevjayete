package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.entity.CrimeSuspect;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.repo.AddressesRepository;
import com.satyamevjayate.api.repo.ContactRepository;
import com.satyamevjayate.api.repo.CrimeSuspectRepository;
import com.satyamevjayate.api.repo.CrimeRepository;
import com.satyamevjayate.api.repo.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CrimeSuspectServices {
    @Autowired
    private CrimeSuspectRepository crimeSuspectRepository;
    
    @Autowired
    private AddressesRepository addressesRepository;
    
    @Autowired
    private ContactRepository contactRepository;
    
    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private CrimeRepository crimeRepository;
    

    public List<CrimeSuspect> listAllCrimeSuspect()
    {
        return crimeSuspectRepository.findAll();
    }

    public CrimeSuspect saveCrimeSuspect(CrimeSuspect CrimeSuspect)
    {


        addressesRepository.save(CrimeSuspect.getSuspectPermanentAddress());
        addressesRepository.save(CrimeSuspect.getSuspectResidenceAddress());
        contactRepository.save(CrimeSuspect.getSuspectContact());
        personRepository.save(CrimeSuspect.getSuspectPerson());
 	     
	    return crimeSuspectRepository.save(CrimeSuspect);
    }

    public CrimeSuspect getCrimeSuspect(Long Id)
    {
        return crimeSuspectRepository.findById(Id).get();
    }

    public void deleteCrimeSuspect(Long Id)
    {
        crimeSuspectRepository.deleteById(Id);
    }
}
