package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.PoliceStation;
import com.satyamevjayate.api.repo.AddressesRepository;
import com.satyamevjayate.api.repo.ContactRepository;
import com.satyamevjayate.api.repo.PoliceStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
public class PoliceStationServices {
    @Autowired
    private PoliceStationRepository PoliceStation_Repo;
    
    @Autowired
    private AddressesRepository address_repo;
    
    @Autowired
    private ContactRepository contact_repo;

    public List<PoliceStation> listAll_PoliceStation()
    {
        System.out.println(PoliceStation_Repo.findAll());
        return PoliceStation_Repo.findAll();
    }

    public PoliceStation save_PoliceStation(PoliceStation PoliceStation)
    {
//    	 Addresses address = address_repo.findById(PoliceStation.getPolicePermanentAddress().getAddressID()).orElse(null);
//	        if (null == address) {
//	          Addresses address = new Addresses();
////	        }
//	        address.setAddressLine1(PoliceStation.getPolicestationAddress().getAddressLine1());
//	        address.setAddressLine2(PoliceStation.getPolicestationAddress().getAddressLine2());
//	        address.setCity(PoliceStation.getPolicestationAddress().getCity());
//	        address.setCountry(PoliceStation.getPolicestationAddress().getCountry());
//	        address.setState(PoliceStation.getPolicestationAddress().getState());
//	        address.setZipcode(PoliceStation.getPolicestationAddress().getZipcode());
//	        address_repo.save(address);
//	        PoliceStation.setPolicestationAddress(address);
//	        
//	        
//	      
//	        
////	    Contact contact=contact_repo.findById(PoliceStation.getPoliceStationContact().getContactId()).orElse(null);
////	    	if(null==contact)
////	    	{
//	    	Contact contact=new Contact();
////	    	}
//	    	contact.setContactNumber(PoliceStation.getPoliceStationContact().getContactNumber());
//		    contact.setContactEmail(PoliceStation.getPoliceStationContact().getContactEmail());
//		    contact_repo.save(contact);
//		    PoliceStation.setPoliceStationContact(contact);
    	
    	address_repo.save(PoliceStation.getPolicestationAddress());
    	contact_repo.save(PoliceStation.getPoliceStationContact());
       return PoliceStation_Repo.save(PoliceStation);
    }

    public PoliceStation getPoliceStation(Long Id)
    {
        return PoliceStation_Repo.findById(Id).get();
    }

    public void delete_PoliceStation(Long Id)
    {
        PoliceStation_Repo.deleteById(Id);
    }

}
