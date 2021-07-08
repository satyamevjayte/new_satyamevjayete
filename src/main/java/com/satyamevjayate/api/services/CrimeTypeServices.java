package com.satyamevjayate.api.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.satyamevjayate.api.entity.CrimeType;
import com.satyamevjayate.api.repo.CrimeTypeRepository;

@Service
public class CrimeTypeServices {
	
	@Autowired
	private CrimeTypeRepository crimeTypeRepository;
	
	public List<CrimeType> listAllCrimeType()
	{
		return crimeTypeRepository.findAll();
	}
	
	public void saveCrimeType(CrimeType crimetype)
	{
		crimeTypeRepository.save(crimetype);
	}
	
	public CrimeType getCrimeType(Long Id)
	{
		return crimeTypeRepository.findById(Id).get();
	}
	
	public void deleteCrimeType(Long Id)
	{
		crimeTypeRepository.deleteById(Id);
	}
	
	
	

}
