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
    private PoliceStationRepository policeStationRepository;
    
    @Autowired
    private AddressesRepository addressesRepository;
    
    @Autowired
    private ContactRepository contactRepository;

    public List<PoliceStation> listAll_PoliceStation()
    {
        System.out.println(policeStationRepository.findAll());
        return policeStationRepository.findAll();
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

        addressesRepository.save(PoliceStation.getPolicestationAddress());
        contactRepository.save(PoliceStation.getPoliceStationContact());
       return policeStationRepository.save(PoliceStation);
    }

    public PoliceStation getPoliceStation(Long Id)
    {
        return policeStationRepository.findById(Id).get();
    }

    public void delete_PoliceStation(Long Id)
    {
        policeStationRepository.deleteById(Id);
    }

}
