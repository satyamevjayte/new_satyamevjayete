package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.entity.CrimeImage;
import com.satyamevjayate.api.entity.CrimeType;
import com.satyamevjayate.api.repo.CrimeImageRepository;
import com.satyamevjayate.api.repo.CrimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CrimeImageServices {
    @Autowired
    private CrimeImageRepository crimeImageRepository;
    
    @Autowired
    private CrimeRepository crime_repo;

    public List<CrimeImage> listAllCrimeImage()
    {
        return crimeImageRepository.findAll();
    }

    public CrimeImage saveCrimeImage(CrimeImage CrimeImage)
    {
//    	 Crime crime = crime_repo.findById(CrimeImage.getImageCrimeId().getCrimeID()).orElse(null);
//	        if (null == crime) {
//	            crime = new Crime();
//	        }
//	        crime.setCrimeID(CrimeImage.getImageCrimeId().getCrimeID());
//	        CrimeImage.setImageCrimeId(crime);
	       
	     return crimeImageRepository.save(CrimeImage);
    }

    public CrimeImage getCrimeImage(Long Id)
    {
        return crimeImageRepository.findById(Id).get();
    }

    public void deleteCrimeImage(Long Id)
    {
        crimeImageRepository.deleteById(Id);
    }
}
