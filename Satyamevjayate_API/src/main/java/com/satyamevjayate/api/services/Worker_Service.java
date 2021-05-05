package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.entity.Worker;
import com.satyamevjayate.api.repo.Addresses_Repository;
import com.satyamevjayate.api.repo.Contact_Repository;
import com.satyamevjayate.api.repo.Person_Repository;
import com.satyamevjayate.api.repo.Worker_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
public class Worker_Service {
    @Autowired
    private Worker_Repository Worker_repo;
    
    @Autowired
    private Addresses_Repository address_repo;
    
    @Autowired
    private Contact_Repository contact_repo;
    
    @Autowired
    private Person_Repository person_repo;
    

    public List<Worker> listAllWorker()
    {
        return Worker_repo.findAll();
    }

    public Worker saveWorker(Worker worker)
    {
//    	Addresses address = address_repo.findById(worker.getWorkeraddress().getAddressID()).orElse(null);
//        if (null == address) {
        	Addresses   address = new Addresses();
//        }
        address.setAddressLine1(worker.getWorkerAddress().getAddressLine1());
        address.setAddressLine2(worker.getWorkerAddress().getAddressLine2());
        address.setCity(worker.getWorkerAddress().getCity());
        address.setCountry(worker.getWorkerAddress().getCountry());
        address.setState(worker.getWorkerAddress().getState());
        address.setZipcode(worker.getWorkerAddress().getZipcode());
        address_repo.save(address);
        worker.setWorkerAddress(address);
        
//    Contact contact=contact_repo.findById(worker.getWorkercontact().getContactId()).orElse(null);
//    	if(null==contact)
//    	{
    	Contact contact=new Contact();
//    	}
    	contact.setContactNumber(worker.getWorkerContact().getContactNumber());
	    contact.setContactEmail(worker.getWorkerContact().getContactEmail());
	    contact_repo.save(contact);
	    worker.setWorkerContact(contact);
	    
//	Person person = person_repo.findById(worker.getWorkerperson().getPerson_Id()).orElse(null);
//        if (null == person) {
        	Person person = new Person();
//        }
        person.setFirstName(worker.getWorkerPerson().getFirstName());
        person.setLastName(worker.getWorkerPerson().getLastName());
        person.setGender(worker.getWorkerPerson().getGender());
        person.setDateOfBirth(worker.getWorkerPerson().getDateOfBirth());
        person.setPersonImage(worker.getWorkerPerson().getPersonImage());
        person_repo.save(person);
        worker.setWorkerPerson(person);
       return Worker_repo.save(worker);
    }
    public Worker editWorker(Worker worker)
    {
    	Addresses address = address_repo.findById(worker.getWorkerAddress().getAddressID()).orElse(null);
        if (null == address) {
        	   address = new Addresses();
        }
        address.setAddressLine1(worker.getWorkerAddress().getAddressLine1());
        address.setAddressLine2(worker.getWorkerAddress().getAddressLine2());
        address.setCity(worker.getWorkerAddress().getCity());
        address.setCountry(worker.getWorkerAddress().getCountry());
        address.setState(worker.getWorkerAddress().getState());
        address.setZipcode(worker.getWorkerAddress().getZipcode());
      
        worker.setWorkerAddress(address);
        
    Contact contact=contact_repo.findById(worker.getWorkerContact().getContactId()).orElse(null);
    	if(null==contact)
    	{
    		contact=new Contact();
    	}
    	contact.setContactNumber(worker.getWorkerContact().getContactNumber());
	    contact.setContactEmail(worker.getWorkerContact().getContactEmail());
	  
	    worker.setWorkerContact(contact);
	    
	Person person = person_repo.findById(worker.getWorkerPerson().getPersonId()).orElse(null);
        if (null == person) {
        	 person = new Person();
        }
        person.setFirstName(worker.getWorkerPerson().getFirstName());
        person.setLastName(worker.getWorkerPerson().getLastName());
        person.setGender(worker.getWorkerPerson().getGender());
        person.setDateOfBirth(worker.getWorkerPerson().getDateOfBirth());
        person.setPersonImage(worker.getWorkerPerson().getPersonImage());
        worker.setWorkerPerson(person);
    
       return Worker_repo.save(worker);
    }

    public Worker getWorker(BigInteger Id)
    {
        return Worker_repo.findById(Id).get();
    }

    public void deleteWorker(BigInteger Id)
    {
        Worker_repo.deleteById(Id);
    }
}
