package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Complainer;
import com.satyamevjayate.api.entity.ComplainerDocument;
import com.satyamevjayate.api.repo.ComplainerDocumentRepository;
import com.satyamevjayate.api.repo.ComplainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplainerDocumentServices {
    @Autowired
    private ComplainerDocumentRepository complainerDocumentRepository;
    
    @Autowired
    private ComplainerRepository Complainer_repo;

    public List<ComplainerDocument> listAllComplainerDocument()
    {
    	
        return complainerDocumentRepository.findAll();
    }

    public void saveComplainerDocument(ComplainerDocument complainerDocument)
    {

        complainerDocumentRepository.save(complainerDocument);
    }

    public ComplainerDocument getComplainerDocument(Long Id)
    {
        return complainerDocumentRepository.findById(Id).get();
    }

    public void deleteComplainerDocument(Long Id)
    {
        complainerDocumentRepository.deleteById(Id);
    }
}
