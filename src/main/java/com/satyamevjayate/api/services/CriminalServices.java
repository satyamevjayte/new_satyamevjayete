package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Criminal;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.repo.AddressesRepository;
import com.satyamevjayate.api.repo.ContactRepository;
import com.satyamevjayate.api.repo.CriminalRepository;
import com.satyamevjayate.api.repo.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriminalServices {
    @Autowired
    private CriminalRepository criminalRepository;
    
    @Autowired
    private AddressesRepository address_repo;
    
    @Autowired
    private ContactRepository contact_repo;
    
    @Autowired
    private PersonRepository person_repo;

    public List<Criminal> listAllCriminal()
    {
        return criminalRepository.findAll();
    }

    public Criminal saveCriminal(Criminal Criminal)
    {
//    	 Addresses address = address_repo.findById(Criminal.getCriminaladdress().getAddressID()).orElse(null);
//	        if (null == address) {
//	         Addresses address = new Addresses();
////	        }
//	        address.setAddressLine1(Criminal.getCriminalPermanentAddress().getAddressLine1());
//	        address.setAddressLine2(Criminal.getCriminalPermanentAddress().getAddressLine2());
//	        address.setCity(Criminal.getCriminalPermanentAddress().getCity());
//	        address.setCountry(Criminal.getCriminalPermanentAddress().getCountry());
//	        address.setState(Criminal.getCriminalPermanentAddress().getState());
//	        address.setZipcode(Criminal.getCriminalPermanentAddress().getZipcode());
//	        address_repo.save(address);
//	        Criminal.setCriminalPermanentAddress(address);
//	        
//	        
//	        Addresses residenceAddress = new Addresses();
////	        }
//	        residenceAddress.setAddressLine1(Criminal.getCriminalResidenceAddress().getAddressLine1());
//	        residenceAddress.setAddressLine2(Criminal.getCriminalResidenceAddress().getAddressLine2());
//	        residenceAddress.setCity(Criminal.getCriminalResidenceAddress().getCity());
//	        residenceAddress.setCountry(Criminal.getCriminalResidenceAddress().getCountry());
//	        residenceAddress.setState(Criminal.getCriminalResidenceAddress().getState());
//	        residenceAddress.setZipcode(Criminal.getCriminalResidenceAddress().getZipcode());
//	        address_repo.save(residenceAddress);
//	        Criminal.setCriminalResidenceAddress(residenceAddress);
//	        
////	    Contact contact=contact_repo.findById(Criminal.getCriminalcontact().getContactId()).orElse(null);
////	    	if(null==contact)
////	    	{
//	    	Contact	contact=new Contact();
////	    	}
//	    	contact.setContactNumber(Criminal.getCriminalContact().getContactNumber());
//		    contact.setContactEmail(Criminal.getCriminalContact().getContactEmail());
//		    contact_repo.save(contact);
//		    Criminal.setCriminalContact(contact);
//		    
////		Person person = person_repo.findById(Criminal.getCriminalperson().getPerson_Id()).orElse(null);
////	        if (null == person) {
//	         Person person = new Person();
////	        }
//	        person.setFirstName(Criminal.getCriminalPerson().getFirstName());
//	        person.setLastName(Criminal.getCriminalPerson().getLastName());
//	        person.setGender(Criminal.getCriminalPerson().getGender());
//	        person.setDateOfBirth(Criminal.getCriminalPerson().getDateOfBirth());
//	        person.setPersonImage(Criminal.getCriminalPerson().getPersonImage());
//	        person_repo.save(person);
//	        Criminal.setCriminalPerson(person);
//        
    	address_repo.save(Criminal.getCriminalPermanentAddress());
    	address_repo.save(Criminal.getCriminalResidenceAddress());
    	contact_repo.save(Criminal.getCriminalContact());
    	person_repo.save(Criminal.getCriminalPerson());
    	
	     return criminalRepository.save(Criminal);
    }

    
    public Criminal editCriminal(Criminal Criminal)
    {
    	 Addresses address = address_repo.findById(Criminal.getCriminalPermanentAddress().getAddressID()).orElse(null);
	        if (null == address) {
	          address = new Addresses();
	        }
	        address.setAddressLine1(Criminal.getCriminalPermanentAddress().getAddressLine1());
	        address.setAddressLine2(Criminal.getCriminalPermanentAddress().getAddressLine2());
	        address.setCity(Criminal.getCriminalPermanentAddress().getCity());
	        address.setCountry(Criminal.getCriminalPermanentAddress().getCountry());
	        address.setState(Criminal.getCriminalPermanentAddress().getState());
	        address.setZipcode(Criminal.getCriminalPermanentAddress().getZipcode());
	        
	        Criminal.setCriminalPermanentAddress(address);
	        
	        
	        
	     Addresses residenceAddress = address_repo.findById(Criminal.getCriminalResidenceAddress().getAddressID()).orElse(null);
	        if (null == residenceAddress) {
	        	residenceAddress = new Addresses();
	        }
	        residenceAddress.setAddressLine1(Criminal.getCriminalResidenceAddress().getAddressLine1());
	        residenceAddress.setAddressLine2(Criminal.getCriminalResidenceAddress().getAddressLine2());
	        residenceAddress.setCity(Criminal.getCriminalResidenceAddress().getCity());
	        residenceAddress.setCountry(Criminal.getCriminalResidenceAddress().getCountry());
	        residenceAddress.setState(Criminal.getCriminalResidenceAddress().getState());
	        residenceAddress.setZipcode(Criminal.getCriminalResidenceAddress().getZipcode());
	        
	        Criminal.setCriminalResidenceAddress(residenceAddress);
	        
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
        
	     return criminalRepository.save(Criminal);
    }
    
    public Criminal getCriminal(Long Id)
    {
        return criminalRepository.findById(Id).get();
    }

    public void deleteCriminal(Long Id)
    {
        criminalRepository.deleteById(Id);
    }

    public Long findTotalCriminal() {
		return criminalRepository.findTotalCriminal();
    }
}
