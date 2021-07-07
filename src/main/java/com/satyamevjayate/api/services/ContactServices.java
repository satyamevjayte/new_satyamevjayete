package com.satyamevjayate.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.repo.ContactRepository;

@Service
public class ContactServices {
	
	@Autowired
	private ContactRepository contactRepository;
	
	public List<Contact> listAllContact()
	{
		return contactRepository.findAll();
	}
	
	public void saveContact(Contact contact)
	{
		contactRepository.save(contact);
	}
	
	public Contact getContact(Long Id)
	{
		return contactRepository.findById(Id).get();
	}
	
	public void deleteContact(Long Id)
	{
		contactRepository.deleteById(Id);
	}
	public Long getContactbyEmail(String email)
	{
		Long id= contactRepository.findIdByEmail(email);
		return id;
	}
	
	
	
	

}
