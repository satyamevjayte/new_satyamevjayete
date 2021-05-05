package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.entity.CrimeSuspect;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.repo.Addresses_Repository;
import com.satyamevjayate.api.repo.Contact_Repository;
import com.satyamevjayate.api.repo.CrimeSuspect_Repository;
import com.satyamevjayate.api.repo.Crime_Repository;
import com.satyamevjayate.api.repo.Person_Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CrimeSuspect_Services {
    @Autowired
    private CrimeSuspect_Repository CrimeSuspect_repo;
    
    @Autowired
    private Addresses_Repository address_repo;
    
    @Autowired
    private Contact_Repository contact_repo;
    
    @Autowired
    private Person_Repository person_repo;
    
    @Autowired
    private Crime_Repository crime_repo;
    

    public List<CrimeSuspect> listAllCrimeSuspect()
    {
        return CrimeSuspect_repo.findAll();
    }

    public CrimeSuspect saveCrimeSuspect(CrimeSuspect CrimeSuspect)
    {
    	
    	 Addresses address = address_repo.findById(CrimeSuspect.getSuspectAddress().getAddressID()).orElse(null);
	        if (null == address) {
	            address = new Addresses();
	        }
	        address.setAddressLine1(CrimeSuspect.getSuspectAddress().getAddressLine1());
	        address.setAddressLine2(CrimeSuspect.getSuspectAddress().getAddressLine2());
	        address.setCity(CrimeSuspect.getSuspectAddress().getCity());
	        address.setCountry(CrimeSuspect.getSuspectAddress().getCountry());
	        address.setState(CrimeSuspect.getSuspectAddress().getState());
	        address.setZipcode(CrimeSuspect.getSuspectAddress().getZipcode());
	        CrimeSuspect.setSuspectAddress(address);
	        
	    Contact contact=contact_repo.findById(CrimeSuspect.getSuspectContact().getContactId()).orElse(null);
	    	if(null==contact)
	    	{
	    		contact=new Contact();
	    	}
	    	contact.setContactNumber(CrimeSuspect.getSuspectContact().getContactNumber());
		    contact.setContactEmail(CrimeSuspect.getSuspectContact().getContactEmail());
		    CrimeSuspect.setSuspectContact(contact);
		    
		Person person = person_repo.findById(CrimeSuspect.getSuspectPerson().getPersonId()).orElse(null);
	        if (null == person) {
	            person = new Person();
	        }
	        person.setFirstName(CrimeSuspect.getSuspectPerson().getFirstName());
	        person.setLastName(CrimeSuspect.getSuspectPerson().getLastName());
	        person.setGender(CrimeSuspect.getSuspectPerson().getGender());
	        person.setDateOfBirth(CrimeSuspect.getSuspectPerson().getDateOfBirth());
	        person.setPersonImage(CrimeSuspect.getSuspectPerson().getPersonImage());
	        CrimeSuspect.setSuspectPerson(person);
	           
	    Crime crime = crime_repo.findById(CrimeSuspect.getSuspectCrimeId().getCrimeID()).orElse(null);
	        if (null == crime) {
	            crime = new Crime();
	        }
	        crime.setCrimeID(CrimeSuspect.getSuspectCrimeId().getCrimeID());
	        CrimeSuspect.setSuspectCrimeId(crime);
	        
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
