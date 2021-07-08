package com.satyamevjayate.api.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.Addresses;

import com.satyamevjayate.api.repo.AddressesRepository;

@Service
public class AddressesServices {
	
	@Autowired
	private AddressesRepository addressesRepository;
	
	public List<Addresses> listAllAddresses()
	{
		return addressesRepository.findAll();
	}
	
	public void saveAddress(Addresses address)
	{
		addressesRepository.save(address);
	}
	
	public Addresses getAddress(Long Id)
	{
		return addressesRepository.findById(Id).get();
	}
	
	public void deleteAddress(Long Id)
	{
		addressesRepository.deleteById(Id);
	}

}
