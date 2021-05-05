package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.entity.CrimeVictim;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.repo.Addresses_Repository;
import com.satyamevjayate.api.repo.Contact_Repository;
import com.satyamevjayate.api.repo.CrimeVictim_Repository;
import com.satyamevjayate.api.repo.Crime_Repository;
import com.satyamevjayate.api.repo.Person_Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
public class CrimeVictim_Services {
    @Autowired
    private CrimeVictim_Repository CrimeVictim_repo;
    
    @Autowired
    private Addresses_Repository address_repo;
    
    @Autowired
    private Contact_Repository contact_repo;
    
    @Autowired
    private Person_Repository person_repo;
    
    @Autowired
    private Crime_Repository crime_repo;

    public List<CrimeVictim> listAllCrimeVictim()
    {
        return CrimeVictim_repo.findAll();
    }

    public CrimeVictim saveCrimeVictim(CrimeVictim CrimeVictim)
    {
    	 Addresses address = address_repo.findById(CrimeVictim.getVictimAddress().getAddressID()).orElse(null);
	        if (null == address) {
	            address = new Addresses();
	        }
	        address.setAddressLine1(CrimeVictim.getVictimAddress().getAddressLine1());
	        address.setAddressLine2(CrimeVictim.getVictimAddress().getAddressLine2());
	        address.setCity(CrimeVictim.getVictimAddress().getCity());
	        address.setCountry(CrimeVictim.getVictimAddress().getCountry());
	        address.setState(CrimeVictim.getVictimAddress().getState());
	        address.setZipcode(CrimeVictim.getVictimAddress().getZipcode());
	        CrimeVictim.setVictimAddress(address);
	        
	    Contact contact=contact_repo.findById(CrimeVictim.getCrimeVictimeContact().getContactId()).orElse(null);
	    	if(null==contact)
	    	{
	    		contact=new Contact();
	    	}
	    	contact.setContactNumber(CrimeVictim.getCrimeVictimeContact().getContactNumber());
		    contact.setContactEmail(CrimeVictim.getCrimeVictimeContact().getContactEmail());
		    CrimeVictim.setCrimeVictimeContact(contact);
		    
		Person person = person_repo.findById(CrimeVictim.getVictimPerson().getPersonId()).orElse(null);
	        if (null == person) {
	            person = new Person();
	        }
	        person.setFirstName(CrimeVictim.getVictimPerson().getFirstName());
	        person.setLastName(CrimeVictim.getVictimPerson().getLastName());
	        person.setGender(CrimeVictim.getVictimPerson().getGender());
	        person.setDateOfBirth(CrimeVictim.getVictimPerson().getDateOfBirth());
	        person.setPersonImage(CrimeVictim.getVictimPerson().getPersonImage());
	        CrimeVictim.setVictimPerson(person);
	           
	    Crime crime = crime_repo.findById(CrimeVictim.getCrimeVictimCrimeID().getCrimeID()).orElse(null);
	        if (null == crime) {
	            crime = new Crime();
	        }
	        crime.setCrimeID(CrimeVictim.getCrimeVictimCrimeID().getCrimeID());
	        CrimeVictim.setCrimeVictimCrimeID(crime);
        return CrimeVictim_repo.save(CrimeVictim);
    }

    public CrimeVictim getCrimeVictim(BigInteger Id)
    {
        return CrimeVictim_repo.findById(Id).get();
    }

    public void deleteCrimeVictim(BigInteger Id)
    {
        CrimeVictim_repo.deleteById(Id);
    }
}
