package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.entity.PrisonerLaw;
import com.satyamevjayate.api.entity.Prisoners;
import com.satyamevjayate.api.repo.PersonRepository;
import com.satyamevjayate.api.repo.PrisonerLawRepository;
import com.satyamevjayate.api.repo.PrisonersReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrisonerServices {
    @Autowired
    private PrisonersReporsitory prisonersReporsitory;
    
    @Autowired
    private PersonRepository person_repo;

    public List<Prisoners> listAllPrisoners()
    {
        return prisonersReporsitory.findAll();
    }

    public Long savePrisoners(Prisoners prisoners)
    {
    	
        prisonersReporsitory.save(prisoners);
        return prisoners.getPrisonerID();
    }

    public Prisoners getPrisoners(Long Id)
    {
        return prisonersReporsitory.findById(Id).get();
    }

    public void deletePrisoners(Long Id)
    {
        prisonersReporsitory.deleteById(Id);
    }
    public Long editPrisoners(Prisoners prisoners,Long id)
    {
        prisonersReporsitory.save(prisoners);
        return id;
    }
}
