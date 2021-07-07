package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.PoliceDocument;
import com.satyamevjayate.api.entity.PrisonerLaw;
import com.satyamevjayate.api.repo.PoliceDocumentRepository;
import com.satyamevjayate.api.repo.PrisonerLawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrisonerLawServices {
    @Autowired
    private PrisonerLawRepository prisonerLawRepository;

    public List<PrisonerLaw> listAllPrisonerLaw()
    {
        return prisonerLawRepository.findAll();
    }

    public Long savePrisonerLaw(PrisonerLaw prisonerLaw)
    {
        prisonerLawRepository.save(prisonerLaw);
        return prisonerLaw.getPrisonerLawID();
    }

    public PrisonerLaw getPrisonerLaw(Long Id)
    {
        return prisonerLawRepository.findById(Id).get();
    }

    public void deletePrisonerLaw(Long Id)
    {
        prisonerLawRepository.deleteById(Id);
    }
    public Long editPrisonerLaw(PrisonerLaw prisonerLaw,Long id)
    {
        prisonerLawRepository.save(prisonerLaw);
        return id;
    }

}
