package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.CrimeSuspect;
import com.satyamevjayate.api.entity.CrimeVictim;
import com.satyamevjayate.api.entity.CrimeVictimDocument;
import com.satyamevjayate.api.repo.CrimeVictimDocumentRepository;
import com.satyamevjayate.api.repo.CrimeVictimRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

public class CrimeVictimDocumentService {
    @Autowired
    private CrimeVictimDocumentRepository CrimeVictimDocument_repo;
    
    @Autowired
    private CrimeVictimRepository CrimeVictim_repo;

    public List<CrimeVictimDocument> listAllCrimeVictimDocument()
    {
        return CrimeVictimDocument_repo.findAll();
    }

    public CrimeVictimDocument saveCrimeVictimDocument(CrimeVictimDocument CrimeVictimDocument)
    {
    	CrimeVictim crimevictim = CrimeVictim_repo.findById(CrimeVictimDocument.getCrimeVictimDocumentID().getCrimeVictimID()).orElse(null);
        if (null == crimevictim) {
        	crimevictim = new CrimeVictim();
        }
        crimevictim.setCrimeVictimID(CrimeVictimDocument.getCrimeVictimDocumentID().getCrimeVictimID());
        CrimeVictimDocument.setCrimeVictimDocumentID(crimevictim);
        return CrimeVictimDocument_repo.save(CrimeVictimDocument);
    }

    public CrimeVictimDocument getCrimeVictimDocument(BigInteger Id)
    {
        return CrimeVictimDocument_repo.findById(Id).get();
    }

    public void deleteCrimeVictimDocument(BigInteger Id)
    {
        CrimeVictimDocument_repo.deleteById(Id);
    }
}
