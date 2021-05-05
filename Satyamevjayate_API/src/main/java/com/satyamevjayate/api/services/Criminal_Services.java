package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Criminal;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.repo.Addresses_Repository;
import com.satyamevjayate.api.repo.Contact_Repository;
import com.satyamevjayate.api.repo.Criminal_Repository;
import com.satyamevjayate.api.repo.Person_Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Criminal_Services {
    @Autowired
    private Criminal_Repository Criminal_repo;
    
    @Autowired
    private Addresses_Repository address_repo;
    
    @Autowired
    private Contact_Repository contact_repo;
    
    @Autowired
    private Person_Repository person_repo;

    public List<Criminal> listAllCriminal()
    {
        return Criminal_repo.findAll();
    }

    public Criminal saveCriminal(Criminal Criminal)
    {
//    	 Addresses address = address_repo.findById(Criminal.getCriminaladdress().getAddressID()).orElse(null);
//	        if (null == address) {
	         Addresses address = new Addresses();
//	        }
	        address.setAddressLine1(Criminal.getCriminalAddress().getAddressLine1());
	        address.setAddressLine2(Criminal.getCriminalAddress().getAddressLine2());
	        address.setCity(Criminal.getCriminalAddress().getCity());
	        address.setCountry(Criminal.getCriminalAddress().getCountry());
	        address.setState(Criminal.getCriminalAddress().getState());
	        address.setZipcode(Criminal.getCriminalAddress().getZipcode());
	        address_repo.save(address);
	        Criminal.setCriminalAddress(address);
	        
//	    Contact contact=contact_repo.findById(Criminal.getCriminalcontact().getContactId()).orElse(null);
//	    	if(null==contact)
//	    	{
	    	Contact	contact=new Contact();
//	    	}
	    	contact.setContactNumber(Criminal.getCriminalContact().getContactNumber());
		    contact.setContactEmail(Criminal.getCriminalContact().getContactEmail());
		    contact_repo.save(contact);
		    Criminal.setCriminalContact(contact);
		    
//		Person person = person_repo.findById(Criminal.getCriminalperson().getPerson_Id()).orElse(null);
//	        if (null == person) {
	         Person person = new Person();
//	        }
	        person.setFirstName(Criminal.getCriminalPerson().getFirstName());
	        person.setLastName(Criminal.getCriminalPerson().getLastName());
	        person.setGender(Criminal.getCriminalPerson().getGender());
	        person.setDateOfBirth(Criminal.getCriminalPerson().getDateOfBirth());
	        person.setPersonImage(Criminal.getCriminalPerson().getPersonImage());
	        person_repo.save(person);
	        Criminal.setCriminalPerson(person);
        
	     return Criminal_repo.save(Criminal);
    }

    
    public Criminal editCriminal(Criminal Criminal)
    {
    	 Addresses address = address_repo.findById(Criminal.getCriminalAddress().getAddressID()).orElse(null);
	        if (null == address) {
	          address = new Addresses();
	        }
	        address.setAddressLine1(Criminal.getCriminalAddress().getAddressLine1());
	        address.setAddressLine2(Criminal.getCriminalAddress().getAddressLine2());
	        address.setCity(Criminal.getCriminalAddress().getCity());
	        address.setCountry(Criminal.getCriminalAddress().getCountry());
	        address.setState(Criminal.getCriminalAddress().getState());
	        address.setZipcode(Criminal.getCriminalAddress().getZipcode());
	       
	        Criminal.setCriminalAddress(address);
	        
	    Contact contact=contact_repo.findById(Criminal.getCriminalContact().getContactId()).orElse(null);
	    	if(null==contact)
	    	{
	    		contact=new Contact();
	    	}
	    	contact.setContactNumber(Criminal.getCriminalContact().getContactNumber());
		    contact.setContactEmail(Criminal.getCriminalContact().getContactEmail());
		  
		    Criminal.setCriminalContact(contact);
		    
		Person person = person_repo.findById(Criminal.getCriminalPerson().getPersonId()).orElse(null);
	        if (null == person) {
	         person = new Person();
	        }
	        person.setFirstName(Criminal.getCriminalPerson().getFirstName());
	        person.setLastName(Criminal.getCriminalPerson().getLastName());
	        person.setGender(Criminal.getCriminalPerson().getGender());
	        person.setDateOfBirth(Criminal.getCriminalPerson().getDateOfBirth());
	        person.setPersonImage(Criminal.getCriminalPerson().getPersonImage());
	      
	        Criminal.setCriminalPerson(person);
        
	     return Criminal_repo.save(Criminal);
    }
    
    public Criminal getCriminal(Long Id)
    {
        return Criminal_repo.findById(Id).get();
    }

    public void deleteCriminal(Long Id)
    {
        Criminal_repo.deleteById(Id);
    }
}
