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
import org.springframework.web.bind.annotation.RestController;


import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.services.ContactServices;

@RestController
public class ContactController {
	
	@Autowired
	private ContactServices contactServices;
	
	@GetMapping("/contact")
	public List<Contact> getAllContact() {
		return contactServices.listAllContact();
	}
	
	@GetMapping("/contact/{id}")
	public Contact getAddresses(@PathVariable Long id)
	{
		Contact contact= contactServices.getContact(id);
		return contact;
	}
	
	@PostMapping("/contact")
	public String addContact(@RequestBody Contact contact)
	{
		contactServices.saveContact(contact);;
		return "Contact Add Successfully";
	}	
	
	
	@DeleteMapping("/contact/{id}")
	public String deleteContact(@PathVariable Long id)
	{
		contactServices.deleteContact(id);
	    return "Delete Contact Successfully";
	}
	
	@PutMapping("/contact/{id}")
	public ResponseEntity<Object> editContact(@RequestBody Contact contact, @PathVariable Long id) {

		

		contact.setContactId(id);
		
		contactServices.saveContact(contact);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/conatactbyemail/{email}")
	public Long policeRoleByName( @PathVariable String email) {

		Long id=	contactServices.getContactbyEmail(email);

		return id;
	}
}
