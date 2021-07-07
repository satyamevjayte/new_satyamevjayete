package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Complainer;
import com.satyamevjayate.api.entity.PoliceDocument;
import com.satyamevjayate.api.entity.Prison;
import com.satyamevjayate.api.repo.AddressesRepository;
import com.satyamevjayate.api.repo.ComplainerRepository;
import com.satyamevjayate.api.repo.PrisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrisonServices {
    @Autowired
    private PrisonRepository prisonRepository;
    
    @Autowired
    private AddressesRepository address_repo;

    public List<Prison> listAllPrison()
    {
        return prisonRepository.findAll();
    }

    public Long savePrison(Prison prison)
    {
    	
//    	   Addresses  address = new Addresses();
////	        }
//		    System.out.println(prison.getPrisonAddress().getAddressLine1());
//	        address.setAddressLine1(prison.getPrisonAddress().getAddressLine1());
//	        address.setAddressLine2(prison.getPrisonAddress().getAddressLine2());
//	        address.setCity(prison.getPrisonAddress().getCity());
//	        address.setCountry(prison.getPrisonAddress().getCountry());
//	        address.setState(prison.getPrisonAddress().getState());
//	        address.setZipcode(prison.getPrisonAddress().getZipcode());
//
//	        address_repo.save(address);
//	        prison.setPrisonAddress(address);
    	address_repo.save(prison.getPrisonAddress());
        prisonRepository.save(prison);
        return prison.getPrisonID();
    }

    public Prison getPrison(Long Id)
    {
        return prisonRepository.findById(Id).get();
    }

    public void deletePrison(Long Id)
    {
        prisonRepository.deleteById(Id);
    }
    public Long editPrison(Prison prison, Long id)
    {
        prisonRepository.save(prison);
        return id;
    }

    public Long findTotalPrison() {
        return prisonRepository.findTotalPrison();
    }
}
