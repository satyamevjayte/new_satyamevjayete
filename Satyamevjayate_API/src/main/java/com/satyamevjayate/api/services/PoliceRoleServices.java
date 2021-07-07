package com.satyamevjayate.api.services;

import java.math.BigInteger;
import java.util.List;

import com.satyamevjayate.api.entity.Police;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.PoliceRole;
import com.satyamevjayate.api.repo.PoliceRoleRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


@Service
public class PoliceRoleServices {
	
	@Autowired
	private PoliceRoleRepository policeRoleRepository;
	@Autowired
	private EntityManager entityManager;
	public List<PoliceRole> listAllPoliceRole()
	{
		return policeRoleRepository.findAll();
	}
	
	public void savePoliceRole(PoliceRole policeRole)
	{
		policeRoleRepository.save(policeRole);
	}
	
	public PoliceRole getPoliceRole(Long Id)
	{
		return policeRoleRepository.findById(Id).get();
	}
	
	public void deletePoliceRole(Long Id)
	{
		policeRoleRepository.deleteById(Id);
	}
	public Long getPoliceRolebyRoleName(String roleName)
	{
		Long id= policeRoleRepository.findIdByName(roleName);
		return id;
	}
	
	

}
