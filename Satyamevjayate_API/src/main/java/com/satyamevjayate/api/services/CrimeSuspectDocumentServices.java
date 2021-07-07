package com.satyamevjayate.api.services;


import com.satyamevjayate.api.entity.CrimeSuspect;
import com.satyamevjayate.api.entity.CrimeSuspectDocument;
import com.satyamevjayate.api.repo.CrimeSuspectDocumentRepository;
import com.satyamevjayate.api.repo.CrimeSuspectRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

public class CrimeSuspectDocumentServices {
    @Autowired
    private CrimeSuspectDocumentRepository CrimeSuspectDocument_repo;
    
    @Autowired
    private CrimeSuspectRepository crimesuspect_repo;

    public List<CrimeSuspectDocument> listAllCrimeSuspectDocument()
    {
        return CrimeSuspectDocument_repo.findAll();
    }

    public CrimeSuspectDocument saveCrimeSuspectDocument(CrimeSuspectDocument CrimeSuspectDocument)
    {
    	CrimeSuspect crimesuspect = crimesuspect_repo.findById(CrimeSuspectDocument.getCrimeSuspectDocument().getCrimeSuspectID()).orElse(null);
        if (null == crimesuspect) {
            crimesuspect = new CrimeSuspect();
        }
        crimesuspect.setCrimeSuspectID(CrimeSuspectDocument.getCrimeSuspectDocument().getCrimeSuspectID());
        CrimeSuspectDocument.setCrimeSuspectDocument(crimesuspect);
    	return CrimeSuspectDocument_repo.save(CrimeSuspectDocument);
    }

    public CrimeSuspectDocument getCrimeSuspectDocument(BigInteger Id)
    {
        return CrimeSuspectDocument_repo.findById(Id).get();
    }

    public void deleteCrimeSuspectDocument(BigInteger Id)
    {
        CrimeSuspectDocument_repo.deleteById(Id);
    }
}
