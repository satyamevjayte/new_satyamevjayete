package com.satyamevjayate.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.satyamevjayate.api.entity.*;
import com.satyamevjayate.api.model.CRimeTypewiseCrime;
import com.satyamevjayate.api.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.model.policeModel;
import org.springframework.web.client.RestTemplate;

import javax.xml.crypto.Data;

@Service
public class PoliceServices {
	
	@Autowired
	private PoliceRepository policeRepository;
	
	@Autowired
	private AddressesRepository addressesRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PoliceRoleRepository policeRoleRepository;
	
	@Autowired
	private PoliceStationRepository policeStationRepository;
	
	
	public List<Police> listAllPolice()
	{
		return policeRepository.findAll();
	}
	
	public Police editPolice(Police police)
	{
		
		 Addresses address = addressesRepository.findById(police.getPolicePermanentAddress().getAddressID()).orElse(null);
	        if (null == address) {
	            address = new Addresses();
	        }
	        //System.out.println(police.getPolicePermanentAddress().getAddressLine1());
	        address.setAddressLine1(police.getPolicePermanentAddress().getAddressLine1());
	        address.setAddressLine2(police.getPolicePermanentAddress().getAddressLine2());
	        address.setCity(police.getPolicePermanentAddress().getCity());
	        address.setCountry(police.getPolicePermanentAddress().getCountry());
	        address.setState(police.getPolicePermanentAddress().getState());
	        address.setZipcode(police.getPolicePermanentAddress().getZipcode());

	        
	        police.setPolicePermanentAddress(address);
	        
	        
	     Addresses residenceAddress = addressesRepository.findById(police.getPoliceResidenceAddress().getAddressID()).orElse(null);
	        if (null == residenceAddress) {
	        	residenceAddress = new Addresses();
	        }
	        //System.out.println(police.getPolicePermanentAddress().getAddressLine1());
	        residenceAddress.setAddressLine1(police.getPoliceResidenceAddress().getAddressLine1());
	        residenceAddress.setAddressLine2(police.getPoliceResidenceAddress().getAddressLine2());
	        residenceAddress.setCity(police.getPoliceResidenceAddress().getCity());
	        residenceAddress.setCountry(police.getPoliceResidenceAddress().getCountry());
	        residenceAddress.setState(police.getPoliceResidenceAddress().getState());
	        residenceAddress.setZipcode(police.getPoliceResidenceAddress().getZipcode());

	        
	        police.setPoliceResidenceAddress(residenceAddress);
	        
	    Contact contact= contactRepository.findById(police.getPoliceContact().getContactId()).orElse(null);
	    	if(null==contact)
	    	{
	    		contact=new Contact();
	    	}
	    	contact.setContactNumber(police.getPoliceContact().getContactNumber());
		    contact.setContactEmail(police.getPoliceContact().getContactEmail());
		
		    police.setPoliceContact(contact);
		    
		Person person = personRepository.findById(police.getPerson().getPersonId()).orElse(null);
	        if (null == person) {
	        	person = new Person();
	        }
	        person.setFirstName(police.getPerson().getFirstName());
	        person.setLastName(police.getPerson().getLastName());
	        person.setGender(police.getPerson().getGender());
	        person.setDateOfBirth(police.getPerson().getDateOfBirth());
	        person.setPersonImage(police.getPerson().getPersonImage());
	        
	       
	        police.setPerson(person);
	        
		    
	        
	        return policeRepository.save(police);
		
		
		
	}
	
	public policeModel getPolice(Long Id)
	{
		
		
		policeModel policemodel =new policeModel();
		Optional<Police> police=policeRepository.findById(Id);
		if(police.isPresent()){
		   Police police1=new Police();
		   police1=police.get();
		   List <Police>ps=new ArrayList<>();
		   ps.add(police1);
		   policemodel.setMessage("Record fetched Successfully!!");
		   policemodel.setPolice(ps);
		}
		else{
		   policemodel.setMessage("No Record in Police");
		}
		return policemodel;
		
//		return police_repo.findById(Id).get();
	}
	
	public Police savePolice(Police police)
	{
		addressesRepository.save(police.getPolicePermanentAddress());
		addressesRepository.save(police.getPoliceResidenceAddress());
		contactRepository.save(police.getPoliceContact());
		personRepository.save(police.getPerson());
		return policeRepository.save(police);
	}
		
	public void deletePolice(Long Id)
	{
		policeRepository.deleteById(Id);
	}

	public Police policeLogin(String email, String pwd){
		Long contactId;
		HttpHeaders headers = new HttpHeaders();
//		String uri="http://localhost:8080/authenticate";
		RestTemplate restTemplate = new RestTemplate();
		DAOUser daoUser=new DAOUser();
		daoUser.setUsername(email);
		daoUser.setPassword(pwd);

//		ResponseEntity<String> token=restTemplate.postForEntity(uri,daoUser,String.class);
		headers.add("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuaXNoYVlhZGF2IiwiZXhwIjoxNjI1NjgzOTg2LCJpYXQiOjE2MjU2Mjk5ODZ9.vhvJBSXLV8eqn9DwpxtVlk6VuOPxtK6Cr9bDK6V-z4RwCXJJ51XCEYhuSIffxc903PD7S3CD0SoKiQOwnHF9ag");
		HttpEntity request = new HttpEntity(headers);
		 String uri = "http://localhost:8080/conatactbyemail/"+email;

		ResponseEntity<Long> id1=restTemplate.exchange(uri, HttpMethod.GET,request, Long.class);
		contactId= id1.getBody();
		Police police=policeRepository.findIdByPwd(pwd);
		if(Objects.nonNull(contactId) && Objects.nonNull(police)){
			return police;
		}
		else{
			return police;
		}

	}
	public  List<CRimeTypewiseCrime> findRolewiseTotalPolice(){
		List<CRimeTypewiseCrime> data= policeRepository.findRolewisePoliceTotal();
		return data;
	}

	public Long findTotalPolice() {
		return policeRepository.findTotalPolice();
	}
}
