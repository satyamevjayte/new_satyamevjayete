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
    private ComplainLawRepository ComplaineLawRepository;

    public List<ComplainLaw> listAllComplainLaw()
    {
        return ComplaineLawRepository.findAll();
    }

    public void saveComplainLaw(ComplainLaw complainLaw)
    {
        ComplaineLawRepository.save(complainLaw);
    }

    public ComplainLaw getComplainLaw(Long Id)
    {
        return ComplaineLawRepository.findById(Id).get();
    }

    public void deleteComplainLaw(Long Id)
    {
        ComplaineLawRepository.deleteById(Id);
    }

}
