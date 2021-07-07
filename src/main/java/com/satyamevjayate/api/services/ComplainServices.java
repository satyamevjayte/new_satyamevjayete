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
    private ComplianRepository Complian_repo;

    public List<Complain> listAllComplain()
    {
        return Complian_repo.findAll();
    }

    public void saveComplain(Complain complain)
    {
        Complian_repo.save(complain);
    }

    public Complain getComplain(Long Id)
    {
        return Complian_repo.findById(Id).get();
    }

    public void deleteComplain(Long Id)
    {
        Complian_repo.deleteById(Id);
    }
}
