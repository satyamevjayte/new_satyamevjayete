package com.satyamevjayate.api.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.satyamevjayate.api.entity.PrisoningType;
import com.satyamevjayate.api.repo.PrisoningTypeRepository;

@Service
public class PrisoningTypeServices {
	
	@Autowired
	private PrisoningTypeRepository prisoningTypeRepository;
	
	public List<PrisoningType> listAllPrisoningType()
	{
		return prisoningTypeRepository.findAll();
	}
	
	public Long savePrisoningType(PrisoningType prisoningtype)
	{
		prisoningTypeRepository.save(prisoningtype);
		return prisoningtype.getPrisoningTypeId();
	}

	public Long updatePrisoningType(PrisoningType prisoningtype,Long id)
	{
		prisoningTypeRepository.save(prisoningtype);
		return id;
	}
	
	public PrisoningType getPrisoningType(Long Id)
	{
		return prisoningTypeRepository.findById(Id).get();
	}
	
	public void deletePrisoningType(Long Id)
	{
		prisoningTypeRepository.deleteById(Id);
	}
	
	

}
