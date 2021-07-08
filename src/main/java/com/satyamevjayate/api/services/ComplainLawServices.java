package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.ComplainLaw;
import com.satyamevjayate.api.entity.ComplainerDocument;
import com.satyamevjayate.api.repo.ComplainLawRepository;
import com.satyamevjayate.api.repo.ComplainerDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplainLawServices {
    @Autowired
    private ComplainLawRepository complainLawRepository;

    public List<ComplainLaw> listAllComplainLaw()
    {
        return complainLawRepository.findAll();
    }

    public void saveComplainLaw(ComplainLaw complainLaw)
    {
        complainLawRepository.save(complainLaw);
    }

    public ComplainLaw getComplainLaw(Long Id)
    {
        return complainLawRepository.findById(Id).get();
    }

    public void deleteComplainLaw(Long Id)
    {
        complainLawRepository.deleteById(Id);
    }

}
