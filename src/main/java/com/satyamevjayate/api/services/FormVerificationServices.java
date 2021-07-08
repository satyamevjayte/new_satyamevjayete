package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.FormVerfication;
import com.satyamevjayate.api.repo.FormVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

public class FormVerificationServices {
    @Autowired
    private FormVerificationRepository formVerificationRepository;

    public List<FormVerfication> listAllFormVerification()
    {
        return formVerificationRepository.findAll();
    }

    public void saveFormVerification(FormVerfication FormVerification)
    {
        formVerificationRepository.save(FormVerification);
    }

    public FormVerfication getFormVerification(Long Id)
    {
        return formVerificationRepository.findById(Id).get();
    }

    public void deleteFormVerification(Long Id)
    {
        formVerificationRepository.deleteById(Id);
    }
}
