package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.entity.CrimeVictim;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.repo.AddressesRepository;
import com.satyamevjayate.api.repo.ContactRepository;
import com.satyamevjayate.api.repo.CrimeVictimRepository;
import com.satyamevjayate.api.repo.CrimeRepository;
import com.satyamevjayate.api.repo.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
public class CrimeVictimServices {
    @Autowired
    private CrimeVictimRepository CrimeVictim_repo;
    
    @Autowired
    private AddressesRepository address_repo;
    
    @Autowired
    private ContactRepository contact_repo;
    
    @Autowired
    private PersonRepository person_repo;
    
    @Autowired
    private CrimeRepository crime_repo;

    public List<CrimeVictim> listAllCrimeVictim()
    {
        return CrimeVictim_repo.findAll();
    }

    public CrimeVictim saveCrimeVictim(CrimeVictim CrimeVictim)
    {
//    	 Addresses address = address_repo.findById(CrimeVictim.getVictimAddress().getAddressID()).orElse(null);
//	        if (null == address) {
//	         Addresses address = new Addresses();
////	        }
//	        address.setAddressLine1(CrimeVictim.getVictimResidenceAddress().getAddressLine1());
//	        address.setAddressLine2(CrimeVictim.getVictimResidenceAddress().getAddressLine2());
//	        address.setCity(CrimeVictim.getVictimResidenceAddress().getCity());
//	        address.setCountry(CrimeVictim.getVictimResidenceAddress().getCountry());
//	        address.setState(CrimeVictim.getVictimResidenceAddress().getState());
//	        address.setZipcode(CrimeVictim.getVictimResidenceAddress().getZipcode());
//	        address_repo.save(address);
//	        CrimeVictim.setVictimResidenceAddress(address);
//	        
//	        
//	        Addresses permanentAddress = new Addresses();
////	        }
//	        permanentAddress.setAddressLine1(CrimeVictim.getVictimPermanentAddress().getAddressLine1());
//	        permanentAddress.setAddressLine2(CrimeVictim.getVictimPermanentAddress().getAddressLine2());
//	        permanentAddress.setCity(CrimeVictim.getVictimPermanentAddress().getCity());
//	        permanentAddress.setCountry(CrimeVictim.getVictimPermanentAddress().getCountry());
//	        permanentAddress.setState(CrimeVictim.getVictimPermanentAddress().getState());
//	        permanentAddress.setZipcode(CrimeVictim.getVictimPermanentAddress().getZipcode());
//	        address_repo.save(permanentAddress);
//	        CrimeVictim.setVictimPermanentAddress(permanentAddress);
//	        
////	    Contact contact=contact_repo.findById(CrimeVictim.getCrimeVictimeContact().getContactId()).orElse(null);
////	    	if(null==contact)
////	    	{
//	    	Contact	contact=new Contact();
////	    	}
//	    	contact.setContactNumber(CrimeVictim.getCrimeVictimeContact().getContactNumber());
//		    contact.setContactEmail(CrimeVictim.getCrimeVictimeContact().getContactEmail());
//		    contact_repo.save(contact);
//		    CrimeVictim.setCrimeVictimeContact(contact);
//		    
////		Person person = person_repo.findById(CrimeVictim.getVictimPerson().getPersonId()).orElse(null);
////	        if (null == person) {
//	         Person person = new Person();
////	        }
//	        person.setFirstName(CrimeVictim.getVictimPerson().getFirstName());
//	        person.setLastName(CrimeVictim.getVictimPerson().getLastName());
//	        person.setGender(CrimeVictim.getVictimPerson().getGender());
//	        person.setDateOfBirth(CrimeVictim.getVictimPerson().getDateOfBirth());
//	        person.setPersonImage(CrimeVictim.getVictimPerson().getPersonImage());
//	        person_repo.save(person);
//	        CrimeVictim.setVictimPerson(person);
//	     
    	
    	address_repo.save(CrimeVictim.getVictimPermanentAddress());
    	address_repo.save(CrimeVictim.getVictimResidenceAddress());
    	contact_repo.save(CrimeVictim.getCrimeVictimeContact());
    	person_repo.save(CrimeVictim.getVictimPerson());
//	    Crime crime = crime_repo.findById(CrimeVictim.getCrimeVictimCrimeID().getCrimeID()).orElse(null);
//	        if (null == crime) {
	          Crime crime = new Crime();
//	        }
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
