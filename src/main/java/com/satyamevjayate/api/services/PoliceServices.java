package com.satyamevjayate.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.satyamevjayate.api.config.TokenGaneration;
import com.satyamevjayate.api.entity.*;
import com.satyamevjayate.api.model.CRimeTypewiseCrime;
import com.satyamevjayate.api.repo.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private UserDao userDao;
	
	
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
		DAOUser daoUser=new DAOUser();
		daoUser.setUsername(police.getPoliceContact().getContactEmail());
		daoUser.setPassword(bcryptEncoder.encode(police.getPwd()));
		userDao.save(daoUser);
		return policeRepository.save(police);
	}
		
	public void deletePolice(Long Id)
	{
		policeRepository.deleteById(Id);
	}


	public Police policeLogin(String email, String pwd){
		Long contactId;
		TokenGaneration tokenGaneration=new TokenGaneration();
		String token=tokenGaneration.tokengeneration(email, pwd);
		HttpHeaders headers = new HttpHeaders();

//		headers.setContentType(MediaType.APPLICATION_JSON);
//		System.out.println(headers.getContentType());
//		String uriau="http://localhost:8080/authenticate";
		RestTemplate restTemplate = new RestTemplate();
//
//		DAOUser daoUser=new DAOUser();
//		daoUser.setUsername(email);
//		daoUser.setPassword(pwd);
//		Gson gson=new Gson();
//		String objjson=gson.toJson(daoUser);
//		HttpEntity<DAOUser> request = new HttpEntity(objjson, headers);
//		System.out.println(request);
//		String token=restTemplate.postForObject(uriau,request,String.class);

		System.out.println("Bearer "+token);






		headers.add("Authorization", "Bearer "+token);
		HttpEntity request1 = new HttpEntity(headers);
		 String uri = "http://localhost:8080/conatactbyemail/"+email;

		ResponseEntity<Long> id1=restTemplate.exchange(uri, HttpMethod.GET,request1, Long.class);
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
