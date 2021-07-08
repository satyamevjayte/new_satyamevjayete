package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.CrimeSuspect;
import com.satyamevjayate.api.entity.CrimeVictim;
import com.satyamevjayate.api.entity.CrimeVictimDocument;
import com.satyamevjayate.api.repo.CrimeVictimDocumentRepository;
import com.satyamevjayate.api.repo.CrimeVictimRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CrimeVictimDocumentService {
    @Autowired
    private CrimeVictimDocumentRepository crimeVictimDocumentRepository;
    
    @Autowired
    private CrimeVictimRepository crimeVictimRepository;

    public List<CrimeVictimDocument> listAllCrimeVictimDocument()
    {
        return crimeVictimDocumentRepository.findAll();
    }

    public CrimeVictimDocument saveCrimeVictimDocument(CrimeVictimDocument CrimeVictimDocument)
    {
    	CrimeVictim crimevictim = crimeVictimRepository.findById(CrimeVictimDocument.getCrimeVictimDocumentID().getCrimeVictimID()).orElse(null);
        if (null == crimevictim) {
        	crimevictim = new CrimeVictim();
        }
        crimevictim.setCrimeVictimID(CrimeVictimDocument.getCrimeVictimDocumentID().getCrimeVictimID());
        CrimeVictimDocument.setCrimeVictimDocumentID(crimevictim);
        return crimeVictimDocumentRepository.save(CrimeVictimDocument);
    }

    public CrimeVictimDocument getCrimeVictimDocument(Long Id)
    {
        return crimeVictimDocumentRepository.findById(Id).get();
    }

    public void deleteCrimeVictimDocument(Long Id)
    {
        crimeVictimDocumentRepository.deleteById(Id);
    }
}
