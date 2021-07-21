package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.FromVerfication1;
import com.satyamevjayate.api.entity.Prisoners;
import com.satyamevjayate.api.repo.FromVerficationRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormVerificationServices1 {
    @Autowired
    private FromVerficationRepository1 fromVerficationRepository1;

    public List<FromVerfication1> listAllFromVerfication1()
    {
        return fromVerficationRepository1.findAll();
    }

    public Long savePrisoners(FromVerfication1 fromVerfication1)
    {
        fromVerficationRepository1.save(fromVerfication1);
        return fromVerfication1.getFormVerifiactionID();
    }

    public FromVerfication1 getFromVerfication1(Long Id)
    {
        return fromVerficationRepository1.findById(Id).get();
    }

    public void deleteFromVerfication1(Long Id)
    {
        fromVerficationRepository1.deleteById(Id);
    }
    public Long editFromVerfication1(FromVerfication1 fromVerfication1,Long id)
    {
        fromVerficationRepository1.save(fromVerfication1);
        return id;
    }


}
