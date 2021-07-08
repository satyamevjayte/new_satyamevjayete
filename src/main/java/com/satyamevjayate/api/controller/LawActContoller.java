package com.satyamevjayate.api.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satyamevjayate.api.entity.LawAct;
import com.satyamevjayate.api.services.LawActServices;

@RequestMapping("/LawActs")
@RestController
public class LawActContoller {
	
	@Autowired
	private LawActServices lawActService;
	
	@GetMapping("")
	public List<LawAct> lawActs()
	{
		return lawActService.listAll_LawAct();
	}
	
	@GetMapping("/{id}")
	public LawAct getLawAct(@PathVariable Long id)
	{
		LawAct l =lawActService.get_Lawact(id);
		return l;
				
	}
	
	@PostMapping("")
	public String addLawact(@RequestBody LawAct l)
	{
		lawActService.save_LawAct(l);
		return "LawAct Add successfully";
	}
	
	@DeleteMapping("/{id}")
	public String deleteLawAct(@PathVariable Long id)
	{
		lawActService.delete_Lawact(id);
		return "LawAct Delete successfully";
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> editLawAct(@RequestBody LawAct lawact , @PathVariable Long id)
	{
		lawact.setLawID(id);
		lawActService.save_LawAct(lawact);
		return ResponseEntity.noContent().build();
	}
	
	

}
