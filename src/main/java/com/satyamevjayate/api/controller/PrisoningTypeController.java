package com.satyamevjayate.api.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.satyamevjayate.api.entity.PrisoningType;
import com.satyamevjayate.api.services.PrisoningTypeServices;

@RestController
public class PrisoningTypeController {
	
	@Autowired
	private PrisoningTypeServices prisoningTypeServices;
	
	@GetMapping("/prisoningtype")
	public List<PrisoningType> getAllPrisoningType() {
		return prisoningTypeServices.listAllPrisoningType();
	}
	
	@GetMapping("/prisoningtype/{id}")
	public PrisoningType getPrisoningType(@PathVariable Long id)
	{
		PrisoningType p= prisoningTypeServices.getPrisoningType(id);
		return p;
	}
	
	@PostMapping("/prisoningtype")
	public Long addPrisoningType(@RequestBody PrisoningType prisoningType)
	{
		 

		return prisoningTypeServices.savePrisoningType(prisoningType);
		
	}
	
	@DeleteMapping("/prisoningtype/{id}")
	public String deletePrisoningType(@PathVariable Long id)
	{
		prisoningTypeServices.deletePrisoningType(id);
		return "PrisoningType Delete successfully";
	}
	
	@PutMapping("/prisoningtype/{id}")
	public Long editPrisoningType(@RequestBody PrisoningType prisoningtype, @PathVariable Long id) {

		Long prisoningtypeId= prisoningTypeServices.updatePrisoningType(prisoningtype,id);

		return prisoningtypeId;
	}
	

}
