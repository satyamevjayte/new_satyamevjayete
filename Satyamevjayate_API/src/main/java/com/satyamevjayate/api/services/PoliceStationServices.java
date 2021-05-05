package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.PoliceStation;
import com.satyamevjayate.api.repo.Addresses_Repository;
import com.satyamevjayate.api.repo.Contact_Repository;
import com.satyamevjayate.api.repo.PoliceStation_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
public class PoliceStationServices {
    @Autowired
    private PoliceStation_Repository PoliceStation_Repo;
    
    @Autowired
    private Addresses_Repository address_repo;
    
    @Autowired
    private Contact_Repository contact_repo;

    public List<PoliceStation> listAll_PoliceStation()
    {
        System.out.println(PoliceStation_Repo.findAll());
        return PoliceStation_Repo.findAll();
    }

    public PoliceStation save_PoliceStation(PoliceStation PoliceStation)
    {
    	 Addresses address = address_repo.findById(PoliceStation.getPoliceStationAddress().getAddressID()).orElse(null);
	        if (null == address) {
	            address = new Addresses();
	        }
	        address.setAddressLine1(PoliceStation.getPoliceStationAddress().getAddressLine1());
	        address.setAddressLine2(PoliceStation.getPoliceStationAddress().getAddressLine2());
	        address.setCity(PoliceStation.getPoliceStationAddress().getCity());
	        address.setCountry(PoliceStation.getPoliceStationAddress().getCountry());
	        address.setState(PoliceStation.getPoliceStationAddress().getState());
	        address.setZipcode(PoliceStation.getPoliceStationAddress().getZipcode());
	        PoliceStation.setPoliceStationAddress(address);
	        
	    Contact contact=contact_repo.findById(PoliceStation.getPoliceStationContact().getContactId()).orElse(null);
	    	if(null==contact)
	    	{
	    		contact=new Contact();
	    	}
	    	contact.setContactNumber(PoliceStation.getPoliceStationContact().getContactNumber());
		    contact.setContactEmail(PoliceStation.getPoliceStationContact().getContactEmail());
		    PoliceStation.setPoliceStationContact(contact);
       return PoliceStation_Repo.save(PoliceStation);
    }

    public PoliceStation getPoliceStation(BigInteger Id)
    {
        return PoliceStation_Repo.findById(Id).get();
    }

    public void delete_PoliceStation(BigInteger Id)
    {
        PoliceStation_Repo.deleteById(Id);
    }

}
