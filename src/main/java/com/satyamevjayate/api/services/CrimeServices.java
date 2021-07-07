package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.model.CRimeTypewiseCrime;
import com.satyamevjayate.api.repo.AddressesRepository;
import com.satyamevjayate.api.repo.CrimeTypeRepository;
import com.satyamevjayate.api.repo.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class CrimeServices {
    @Autowired
    private CrimeRepository crimeRepository;
    
    @Autowired
    private AddressesRepository addressesRepository;
    
    @Autowired
    private CrimeTypeRepository crimetype_repo;

    public List<Crime> listAllCrime()
    {
        return crimeRepository.findAll();
    }

    public Crime saveCrime(Crime Crime)
    {
//    	 Addresses address = address_repo.findById(Crime.getCrmaddress().getAddressID()).orElse(null);
//	        if (null == address) {
	          
//	           Addresses address = new Addresses();
////	        }
//	        address.setAddressLine1(Crime.getCrimeResidenceAddress().getAddressLine1());
//	        address.setAddressLine2(Crime.getCrimeResidenceAddress().getAddressLine2());
//	        address.setCity(Crime.getCrimeResidenceAddress().getCity());
//	        address.setCountry(Crime.getCrimeResidenceAddress().getCountry());
//	        address.setState(Crime.getCrimeResidenceAddress().getState());
//	        address.setZipcode(Crime.getCrimeResidenceAddress().getZipcode());
//	        address_repo.save(address);
//	        Crime.setCrimeResidenceAddress(address);
//	        
//	        
//	        Addresses permanentAddress = new Addresses();
////	        }
//	        permanentAddress.setAddressLine1(Crime.getCrimePermanentAddress().getAddressLine1());
//	        permanentAddress.setAddressLine2(Crime.getCrimePermanentAddress().getAddressLine2());
//	        permanentAddress.setCity(Crime.getCrimePermanentAddress().getCity());
//	        permanentAddress.setCountry(Crime.getCrimePermanentAddress().getCountry());
//	        permanentAddress.setState(Crime.getCrimePermanentAddress().getState());
//	        permanentAddress.setZipcode(Crime.getCrimePermanentAddress().getZipcode());
//	        address_repo.save(permanentAddress);
//	        Crime.setCrimePermanentAddress(permanentAddress);
//	        
////    	System.out.println(Crime.getCrmtype().getCrimeTypeId());
////	      CrimeType crimetype = crimetype_repo.findById(Crime.getCrmtype().getCrimeTypeId()).orElse(new CrimeType());
////	        if (null == crimetype) {
//	           CrimeType crimetype = new CrimeType();
////	        }

   	   	  addressesRepository.save(Crime.getCrimeResidenceAddress());
   	     
    	
	        return crimeRepository.save(Crime);
    }

    public Crime getCrime(BigInteger Id)
    {
        return crimeRepository.findById(Id).get();
    }

    public void deleteCrime(BigInteger Id)
    {
        crimeRepository.deleteById(Id);
    }
    public  List<CRimeTypewiseCrime> findCrimeCrimeTypewise(){
        List<CRimeTypewiseCrime> data= crimeRepository.findCrimeCrimeTypeWise();
        return data;
    }

    public Long findTotalCrime() {
        return crimeRepository.findTotalCrime();
    }
}
