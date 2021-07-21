package com.satyamevjayate.api.controller;

import java.util.List;
import java.util.Objects;

import com.satyamevjayate.api.model.CRimeTypewiseCrime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.satyamevjayate.api.entity.Police;
import com.satyamevjayate.api.model.policeModel;
import com.satyamevjayate.api.repo.AddressesRepository;
import com.satyamevjayate.api.services.PoliceServices;


@RestController

public class policeController {
	
	@Autowired
	private PoliceServices policeServices;

	 @PostMapping("/polices")
	 public String savePolice(@RequestBody Police police)
	 {
	 
	     policeServices.savePolice(police);
	     return "police inserted";
	 }
	
	@GetMapping("/polices")
	public List<Police> findAllPolice()
	{
		 return policeServices.listAllPolice();
	}
	
	@GetMapping("/polices/{id}")
	public policeModel getPolice(@PathVariable Long id)
	{
	     policeModel policemodel= policeServices.getPolice(id);
	     return policemodel;
	}
	
	@PutMapping("/polices/{id}")
	public ResponseEntity<Object> editPolice(@RequestBody Police police, @PathVariable Long id) 
	{

	     police.setPoliceID(id);

	     policeServices.editPolice(police);

	     return ResponseEntity.noContent().build();
	}
	@RequestMapping(value="/changepwdpolices/{id}/{email}/{password}",method = RequestMethod.PUT,consumes = MediaType.ALL_VALUE)
	public String changePassword(@PathVariable String password, @PathVariable Long id, @PathVariable String email)
	{

		policeServices.changePassword(id,password,email);
		return "Password changed successfully! ";

	}
	@DeleteMapping("/polices/{id}")
    public String deletePolice(@PathVariable Long id)
    {
        policeServices.deletePolice(id);
        return "Delete Person Successfully";
    }

	@GetMapping(value="/policelogin")

	public Police policeLogin(@RequestHeader("email") String email, @RequestHeader("pwd") String pwd)
	{
		Police police=policeServices.policeLogin(email,pwd);
		return police;
	}
	@GetMapping("/policerolewise")
	public List<CRimeTypewiseCrime>  getPoliceRolewise()
	{
		List<CRimeTypewiseCrime> crimeCrimeTypewise=policeServices.findRolewiseTotalPolice();
		return crimeCrimeTypewise;
	}
	@GetMapping("/totalPolice")
	public Long  gettotalPolice()
	{
		Long count=policeServices.findTotalPolice();
		return count;
	}
}
