package com.satyamevjayate.api.services;


import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Complainer;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.repo.AddressesRepository;
import com.satyamevjayate.api.repo.ComplainerRepository;
import com.satyamevjayate.api.repo.ContactRepository;
import com.satyamevjayate.api.repo.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplainerServices {

    @Autowired
    private ComplainerRepository Complainer_repo;
    
    @Autowired
	private AddressesRepository address_repo;
	
	@Autowired
	private ContactRepository contact_repo;
	
	@Autowired
	private PersonRepository person_repo;

    public List<Complainer> listAllComplainer()
    {
        return Complainer_repo.findAll();
    }

    public void saveComplainer(Complainer complainer)
    {
    	 	   
//    	   Addresses  address = new Addresses();
//
//		    System.out.println(complainer.getComplainerPermanentAddress().getAddressLine1());
//	        address.setAddressLine1(complainer.getComplainerPermanentAddress().getAddressLine1());
//	        address.setAddressLine2(complainer.getComplainerPermanentAddress().getAddressLine2());
//	        address.setCity(complainer.getComplainerPermanentAddress().getCity());
//	        address.setCountry(complainer.getComplainerPermanentAddress().getCountry());
//	        address.setState(complainer.getComplainerPermanentAddress().getState());
//	        address.setZipcode(complainer.getComplainerPermanentAddress().getZipcode());
//
//	        address_repo.save(address);
//	        complainer.setComplainerPermanentAddress(address);
//	        
//	        
//	        
//	        Addresses  residenceAddress = new Addresses();
//
//		    System.out.println(complainer.getComplainerResidenceAddress().getAddressLine1());
//		    residenceAddress.setAddressLine1(complainer.getComplainerResidenceAddress().getAddressLine1());
//		    residenceAddress.setAddressLine2(complainer.getComplainerResidenceAddress().getAddressLine2());
//		    residenceAddress.setCity(complainer.getComplainerResidenceAddress().getCity());
//		    residenceAddress.setCountry(complainer.getComplainerResidenceAddress().getCountry());
//		    residenceAddress.setState(complainer.getComplainerResidenceAddress().getState());
//		    residenceAddress.setZipcode(complainer.getComplainerResidenceAddress().getZipcode());
//
//	        address_repo.save(residenceAddress);
//	        complainer.setComplainerResidenceAddress(residenceAddress);
//	        
////	    Contact contact=contact_repo.findById(police.getContact().getContactId()).orElse(null);
////	    	if(null==contact)
////	    	{
//	    	Contact	contact=new Contact();
////	    	}
//	    	contact.setContactNumber(complainer.getComplainerContact().getContactNumber());
//		    contact.setContactEmail(complainer.getComplainerContact().getContactEmail());
//		    contact_repo.save(contact);
//		    complainer.setComplainerContact(contact);
//		    
////		Person person = person_repo.findById(police.getPerson().getPerson_Id()).orElse(null);
////	        if (null == person) {
//	         Person person = new Person();
////	        }
//	         person.setFirstName(complainer.getComplainerPerson().getFirstName());
//		     person.setLastName(complainer.getComplainerPerson().getLastName());
//		     person.setGender(complainer.getComplainerPerson().getGender());
//		     person.setDateOfBirth(complainer.getComplainerPerson().getDateOfBirth());
//		     person.setPersonImage(complainer.getComplainerPerson().getPersonImage());
//	        
//	        person_repo.save(person);
//	        complainer.setComplainerPerson(person);
    	
    	   address_repo.save(complainer.getComplainerPermanentAddress());
    	   address_repo.save(complainer.getComplainerResidenceAddress());
    	   contact_repo.save(complainer.getComplainerContact());
    	   person_repo.save(complainer.getComplainerPerson());
    	   Complainer_repo.save(complainer);
    }

    public Complainer getComplainer(Long Id)
    {
        return Complainer_repo.findById(Id).get();
    }

    public void deleteComplainer(Long Id)
    {
        Complainer_repo.deleteById(Id);
    }
}
