package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Complain;
import com.satyamevjayate.api.repo.ComplianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ComplainServices {

    @Autowired
    private ComplianRepository complianRepository;

    public List<Complain> listAllComplain()
    {
        return complianRepository.findAll();
    }

    public void saveComplain(Complain complain)
    {
        complianRepository.save(complain);
    }

    public Complain getComplain(Long Id)
    {
        return complianRepository.findById(Id).get();
    }

    public void deleteComplain(Long Id)
    {
        complianRepository.deleteById(Id);
    }
}
