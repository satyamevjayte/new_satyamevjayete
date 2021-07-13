package com.satyamevjayate.api.services;


import com.satyamevjayate.api.config.TokenGaneration;
import com.satyamevjayate.api.entity.*;
import com.satyamevjayate.api.repo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class ComplainerServices {
    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private UserDao userDao;

    @Autowired
    private ComplainerRepository complainerRepository;
    
    @Autowired
	private AddressesRepository addressesRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private PersonRepository personRepository;

    public List<Complainer> listAllComplainer()
    {
        return complainerRepository.findAll();
    }

    public void saveComplainer(Complainer complainer)
    {
    	 	   
//    	   Addresses  address = new Addresses();
//
//		    System.out.println(complainer.getComplainerPermanentAddress().getAddressLine1());
//	        address.setAddressLine1(complainer.getComplainerPermanentAddress().getAddressLine1());
//	        address.setAddressLine2(complainer.getComplainerPermanentAddress().getAddressLine2());
//	        address.setCity(complainer.getComplainerPermanentAddress().getCity());
//	        address.setCountry(complainer.getComplainerPermanentAddress().getCountry());
//	        address.setState(complainer.getComplainerPermanentAddress().getState());
//	        address.setZipcode(complainer.getComplainerPermanentAddress().getZipcode());
//
//	        address_repo.save(address);
//	        complainer.setComplainerPermanentAddress(address);
//	        
//	        
//	        
//	        Addresses  residenceAddress = new Addresses();
//
//		    System.out.println(complainer.getComplainerResidenceAddress().getAddressLine1());
//		    residenceAddress.setAddressLine1(complainer.getComplainerResidenceAddress().getAddressLine1());
//		    residenceAddress.setAddressLine2(complainer.getComplainerResidenceAddress().getAddressLine2());
//		    residenceAddress.setCity(complainer.getComplainerResidenceAddress().getCity());
//		    residenceAddress.setCountry(complainer.getComplainerResidenceAddress().getCountry());
//		    residenceAddress.setState(complainer.getComplainerResidenceAddress().getState());
//		    residenceAddress.setZipcode(complainer.getComplainerResidenceAddress().getZipcode());
//
//	        address_repo.save(residenceAddress);
//	        complainer.setComplainerResidenceAddress(residenceAddress);
//	        
////	    Contact contact=contact_repo.findById(police.getContact().getContactId()).orElse(null);
////	    	if(null==contact)
////	    	{
//	    	Contact	contact=new Contact();
////	    	}
//	    	contact.setContactNumber(complainer.getComplainerContact().getContactNumber());
//		    contact.setContactEmail(complainer.getComplainerContact().getContactEmail());
//		    contact_repo.save(contact);
//		    complainer.setComplainerContact(contact);
//		    
////		Person person = person_repo.findById(police.getPerson().getPerson_Id()).orElse(null);
////	        if (null == person) {
//	         Person person = new Person();
////	        }
//	         person.setFirstName(complainer.getComplainerPerson().getFirstName());
//		     person.setLastName(complainer.getComplainerPerson().getLastName());
//		     person.setGender(complainer.getComplainerPerson().getGender());
//		     person.setDateOfBirth(complainer.getComplainerPerson().getDateOfBirth());
//		     person.setPersonImage(complainer.getComplainerPerson().getPersonImage());
//	        
//	        person_repo.save(person);
//	        complainer.setComplainerPerson(person);

        addressesRepository.save(complainer.getComplainerPermanentAddress());
        addressesRepository.save(complainer.getComplainerResidenceAddress());
        contactRepository.save(complainer.getComplainerContact());
        personRepository.save(complainer.getComplainerPerson());
        DAOUser daoUser=new DAOUser();
        daoUser.setUsername(complainer.getComplainerContact().getContactEmail());
        daoUser.setPassword(bcryptEncoder.encode(complainer.getPwd()));
        userDao.save(daoUser);
        complainerRepository.save(complainer);


    }

    public Complainer getComplainer(Long Id)
    {
        return complainerRepository.findById(Id).get();
    }

    public void deleteComplainer(Long Id)
    {
        complainerRepository.deleteById(Id);
    }

    public Complainer complainerLogin(String contactEmail, String pwd){
        Long contactId;
        TokenGaneration tokenGaneration = new TokenGaneration();
        System.out.println(""+contactEmail+pwd);
        String token=tokenGaneration.tokengeneration(contactEmail,pwd);
        HttpHeaders headers=new HttpHeaders();
        RestTemplate restTemplate=new RestTemplate();
        System.out.println("Bearer "+token);
        String jwttoken="Bearer "+token;
        System.out.println(jwttoken);

        headers.add("Authorization", jwttoken);
        HttpEntity request1=new HttpEntity(headers);
        String uri = "http://localhost:8080/conatactbyemail/"+contactEmail;

        ResponseEntity<Long> id1=restTemplate.exchange(uri, HttpMethod.GET,request1,Long.class);
        contactId=id1.getBody();
        Complainer complainer=complainerRepository.findIdByPwd(pwd);

        if(Objects.nonNull(contactId)&& Objects.nonNull(complainer)){
            return complainer;
        }else {
            return complainer;
        }

    }
}
