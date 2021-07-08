package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.CrimeVictim;
import com.satyamevjayate.api.entity.Criminal;
import com.satyamevjayate.api.entity.CriminalDocument;
import com.satyamevjayate.api.repo.CriminalDocumentRepository;
import com.satyamevjayate.api.repo.CriminalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CriminalDocumentServices {
    @Autowired
    private CriminalDocumentRepository criminalDocumentRepository;
    
    @Autowired
    private CriminalRepository criminalRepository;

    public List<CriminalDocument> listAllCriminalDocument()
    {
        return criminalDocumentRepository.findAll();
    }

    public CriminalDocument saveCriminalDocument(CriminalDocument CriminalDocument)
    {
//    	Criminal criminal = Criminal_repo.findById(CriminalDocument.getCriminaldoc().getCriminalID()).orElse(null);
//        if (null == criminal) {
//        Criminal criminal = new Criminal();
////       }
//        criminal.setCriminalID(CriminalDocument.getCriminalDocument().getCriminalID());
//        Criminal_repo.save(criminal);
//        CriminalDocument.setCriminalDocument(criminal);
        return criminalDocumentRepository.save(CriminalDocument);
    }

    public CriminalDocument getCriminalDocument(Long Id)
    {
        return criminalDocumentRepository.findById(Id).get();
    }

    public void deleteCriminalDocument(Long Id)
    {
        criminalDocumentRepository.deleteById(Id);
    }
}
