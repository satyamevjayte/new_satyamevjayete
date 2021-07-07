package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.PoliceDocument;
import com.satyamevjayate.api.entity.PoliceRole;
import com.satyamevjayate.api.repo.PoliceDocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliceDocumentServices {
    @Autowired
    private PoliceDocumentRepository policeDocumentRepository;

    public List<PoliceDocument> listAllPoliceDocument()
    {
        return policeDocumentRepository.findAll();
    }

    public Long savePoliceDocument(PoliceDocument policeDocument)
    {
        policeDocumentRepository.save(policeDocument);
        return policeDocument.getDocumentID();
    }

    public PoliceDocument getPoliceDocument(Long Id)
    {
        return policeDocumentRepository.findById(Id).get();
    }

    public void delete_PoliceDocument(Long Id)
    {
        policeDocumentRepository.deleteById(Id);
    }
    public Long editPoliceDocument(PoliceDocument policeDocument,Long id)
    {
        policeDocumentRepository.save(policeDocument);
        return id;
    }

}
