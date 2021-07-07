package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.ComplainLaw;
import com.satyamevjayate.api.entity.Complainer;
import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.entity.CrimeEvidence;
import com.satyamevjayate.api.repo.ComplainLawRepository;
import com.satyamevjayate.api.repo.CrimeEvidenceRepository;
import com.satyamevjayate.api.repo.CrimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrimeEvidenceServices {

    @Autowired
    private CrimeEvidenceRepository crimeEvidenceRepository;
    
    @Autowired
    private CrimeRepository crimeRepository;

    public List<CrimeEvidence> listAllCrimeEvidence()
    {
        return crimeEvidenceRepository.findAll();
    }

    public void saveCrimeEvidence(CrimeEvidence crimeEvidence)
    {
//    	Crime crime=new Crime();
//    	crime.setCrimeEvidenceCrimeID(crimeEvidence.getCrimeEvidenceCrimeID().getCrimeEvidenceCrimeID());
//    	crimeRepository.save(crime);
        crimeEvidenceRepository.save(crimeEvidence);
    }

    public CrimeEvidence getCrimeEvidence(Long Id)
    {
        return crimeEvidenceRepository.findById(Id).get();
    }

    public void deleteCrimeEvidence(Long Id)
    {
        crimeEvidenceRepository.deleteById(Id);
    }
}
