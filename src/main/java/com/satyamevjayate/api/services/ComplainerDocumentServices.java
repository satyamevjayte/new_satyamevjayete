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
    private ComplainerDocumentRepository ComplainerDocument_repo;
    
    @Autowired
    private ComplainerRepository Complainer_repo;

    public List<ComplainerDocument> listAllComplainerDocument()
    {
    	
        return ComplainerDocument_repo.findAll();
    }

    public void saveComplainerDocument(ComplainerDocument complainerDocument)
    {
    	
        ComplainerDocument_repo.save(complainerDocument);
    }

    public ComplainerDocument getComplainerDocument(Long Id)
    {
        return ComplainerDocument_repo.findById(Id).get();
    }

    public void deleteComplainerDocument(Long Id)
    {
        ComplainerDocument_repo.deleteById(Id);
    }
}
