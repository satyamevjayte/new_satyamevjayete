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
    private CrimeSuspectRepository CrimeSuspect_repo;
    
    @Autowired
    private AddressesRepository address_repo;
    
    @Autowired
    private ContactRepository contact_repo;
    
    @Autowired
    private PersonRepository person_repo;
    
    @Autowired
    private CrimeRepository crime_repo;
    

    public List<CrimeSuspect> listAllCrimeSuspect()
    {
        return CrimeSuspect_repo.findAll();
    }

    public CrimeSuspect saveCrimeSuspect(CrimeSuspect CrimeSuspect)
    {
    	

    	address_repo.save(CrimeSuspect.getSuspectPermanentAddress());
 	   	address_repo.save(CrimeSuspect.getSuspectResidenceAddress());
 	   	contact_repo.save(CrimeSuspect.getSuspectContact());
 	   	person_repo.save(CrimeSuspect.getSuspectPerson());
 	     
	    return CrimeSuspect_repo.save(CrimeSuspect);
    }

    public CrimeSuspect getCrimeSuspect(BigInteger Id)
    {
        return CrimeSuspect_repo.findById(Id).get();
    }

    public void deleteCrimeSuspect(BigInteger Id)
    {
        CrimeSuspect_repo.deleteById(Id);
    }
}
