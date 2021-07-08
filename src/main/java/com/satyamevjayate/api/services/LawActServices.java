package com.satyamevjayate.api.services;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.LawAct;

import com.satyamevjayate.api.repo.LawActRepository;

@Service
public class LawActServices {
	@Autowired
	private LawActRepository lawActRepository;
	
      public List<LawAct> listAll_LawAct()
      {
    	  return lawActRepository.findAll();
      }
      
      public void save_LawAct(LawAct lawact)
      {
          lawActRepository.save(lawact);
      }
      
      public LawAct get_Lawact(Long Id)
      {
    	  return lawActRepository.findById(Id).get();
      }
      
      public void  delete_Lawact(Long Id)
      {
          lawActRepository.deleteById(Id);
      }
      

}
