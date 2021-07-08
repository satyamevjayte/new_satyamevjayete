package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.entity.Worker;
import com.satyamevjayate.api.repo.AddressesRepository;
import com.satyamevjayate.api.repo.ContactRepository;
import com.satyamevjayate.api.repo.PersonRepository;
import com.satyamevjayate.api.repo.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;
    
    @Autowired
    private AddressesRepository addressesRepository;
    
    @Autowired
    private ContactRepository contactRepository;
    
    @Autowired
    private PersonRepository personRepository;
    

    public List<Worker> listAllWorker()
    {
        return workerRepository.findAll();
    }

    public Worker saveWorker(Worker worker)
    {
//    	Addresses address = address_repo.findById(worker.getWorkeraddress().getAddressID()).orElse(null);
//        if (null == address) {
//        	Addresses   address = new Addresses();
////        }
//        address.setAddressLine1(worker.getWorkerPermanentAddress().getAddressLine1());
//        address.setAddressLine2(worker.getWorkerPermanentAddress().getAddressLine2());
//        address.setCity(worker.getWorkerPermanentAddress().getCity());
//        address.setCountry(worker.getWorkerPermanentAddress().getCountry());
//        address.setState(worker.getWorkerPermanentAddress().getState());
//        address.setZipcode(worker.getWorkerPermanentAddress().getZipcode());
//        address_repo.save(address);
//        worker.setWorkerPermanentAddress(address);
//        
//        
//    	Addresses   residenceAddress = new Addresses();
////      }
//    	residenceAddress.setAddressLine1(worker.getWorkerResidenceAddress().getAddressLine1());
//    	residenceAddress.setAddressLine2(worker.getWorkerResidenceAddress().getAddressLine2());
//    	residenceAddress.setCity(worker.getWorkerResidenceAddress().getCity());
//    	residenceAddress.setCountry(worker.getWorkerResidenceAddress().getCountry());
//    	residenceAddress.setState(worker.getWorkerResidenceAddress().getState());
//    	residenceAddress.setZipcode(worker.getWorkerResidenceAddress().getZipcode());
//      address_repo.save(residenceAddress);
//      worker.setWorkerResidenceAddress(residenceAddress);
//        
////    Contact contact=contact_repo.findById(worker.getWorkercontact().getContactId()).orElse(null);
////    	if(null==contact)
////    	{
//    	Contact contact=new Contact();
////    	}
//    	contact.setContactNumber(worker.getWorkerContact().getContactNumber());
//	    contact.setContactEmail(worker.getWorkerContact().getContactEmail());
//	    contact_repo.save(contact);
//	    worker.setWorkerContact(contact);
//	    
////	Person person = person_repo.findById(worker.getWorkerperson().getPerson_Id()).orElse(null);
////        if (null == person) {
//        	Person person = new Person();
////        }
//        person.setFirstName(worker.getWorkerPerson().getFirstName());
//        person.setLastName(worker.getWorkerPerson().getLastName());
//        person.setGender(worker.getWorkerPerson().getGender());
//        person.setDateOfBirth(worker.getWorkerPerson().getDateOfBirth());
//        person.setPersonImage(worker.getWorkerPerson().getPersonImage());
//        person_repo.save(person);
//        worker.setWorkerPerson(person);

        addressesRepository.save(worker.getWorkerPermanentAddress());
        addressesRepository.save(worker.getWorkerResidenceAddress());
        contactRepository.save(worker.getWorkerContact());
        personRepository.save(worker.getWorkerPerson());
    	return workerRepository.save(worker);
    }
    public Worker editWorker(Worker worker)
    {
    	Addresses address = addressesRepository.findById(worker.getWorkerPermanentAddress().getAddressID()).orElse(null);
        if (null == address) {
        	   address = new Addresses();
        }
        address.setAddressLine1(worker.getWorkerPermanentAddress().getAddressLine1());
        address.setAddressLine2(worker.getWorkerPermanentAddress().getAddressLine2());
        address.setCity(worker.getWorkerPermanentAddress().getCity());
        address.setCountry(worker.getWorkerPermanentAddress().getCountry());
        address.setState(worker.getWorkerPermanentAddress().getState());
        address.setZipcode(worker.getWorkerPermanentAddress().getZipcode());
       
        worker.setWorkerPermanentAddress(address);
        
        
      Addresses residenceAddress = addressesRepository.findById(worker.getWorkerResidenceAddress().getAddressID()).orElse(null);
        if (null == residenceAddress) {
        	residenceAddress = new Addresses();
        }
        residenceAddress.setAddressLine1(worker.getWorkerResidenceAddress().getAddressLine1());
    	residenceAddress.setAddressLine2(worker.getWorkerResidenceAddress().getAddressLine2());
    	residenceAddress.setCity(worker.getWorkerResidenceAddress().getCity());
    	residenceAddress.setCountry(worker.getWorkerResidenceAddress().getCountry());
    	residenceAddress.setState(worker.getWorkerResidenceAddress().getState());
    	residenceAddress.setZipcode(worker.getWorkerResidenceAddress().getZipcode());
    
      worker.setWorkerResidenceAddress(residenceAddress);
        
    Contact contact=contactRepository.findById(worker.getWorkerContact().getContactId()).orElse(null);
    	if(null==contact)
    	{
    		contact=new Contact();
    	}
    	contact.setContactNumber(worker.getWorkerContact().getContactNumber());
	    contact.setContactEmail(worker.getWorkerContact().getContactEmail());
	  
	    worker.setWorkerContact(contact);
	    
	Person person = personRepository.findById(worker.getWorkerPerson().getPersonId()).orElse(null);
        if (null == person) {
        	 person = new Person();
        }
        person.setFirstName(worker.getWorkerPerson().getFirstName());
        person.setLastName(worker.getWorkerPerson().getLastName());
        person.setGender(worker.getWorkerPerson().getGender());
        person.setDateOfBirth(worker.getWorkerPerson().getDateOfBirth());
        person.setPersonImage(worker.getWorkerPerson().getPersonImage());
        worker.setWorkerPerson(person);
    
       return workerRepository.save(worker);
    }

    public Worker getWorker(Long Id)
    {
        return workerRepository.findById(Id).get();
    }

    public void deleteWorker(Long Id)
    {
        workerRepository.deleteById(Id);
    }
}
