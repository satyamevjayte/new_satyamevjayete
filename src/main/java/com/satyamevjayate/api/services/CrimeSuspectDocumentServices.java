package com.satyamevjayate.api.services;


import com.satyamevjayate.api.entity.CrimeSuspect;
import com.satyamevjayate.api.entity.CrimeSuspectDocument;
import com.satyamevjayate.api.repo.CrimeSuspectDocumentRepository;
import com.satyamevjayate.api.repo.CrimeSuspectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
public class CrimeSuspectDocumentServices {
    @Autowired
    private CrimeSuspectDocumentRepository crimeSuspectDocumentRepository;
    
    @Autowired
    private CrimeSuspectRepository crimeSuspectRepository;

    public List<CrimeSuspectDocument> listAllCrimeSuspectDocument()
    {
        return crimeSuspectDocumentRepository.findAll();
    }

    public CrimeSuspectDocument saveCrimeSuspectDocument(CrimeSuspectDocument CrimeSuspectDocument)
    {
    	CrimeSuspect crimesuspect = crimeSuspectRepository.findById(CrimeSuspectDocument.getCrimeSuspectDocument().getCrimeSuspectID()).orElse(null);
        if (null == crimesuspect) {
            crimesuspect = new CrimeSuspect();
        }
        crimesuspect.setCrimeSuspectID(CrimeSuspectDocument.getCrimeSuspectDocument().getCrimeSuspectID());
        CrimeSuspectDocument.setCrimeSuspectDocument(crimesuspect);
    	return crimeSuspectDocumentRepository.save(CrimeSuspectDocument);
    }

    public CrimeSuspectDocument getCrimeSuspectDocument(Long Id)
    {
        return crimeSuspectDocumentRepository.findById(Id).get();
    }

    public void deleteCrimeSuspectDocument(Long Id)
    {
        crimeSuspectDocumentRepository.deleteById(Id);
    }
}
