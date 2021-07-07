package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.FormVerfication;
import com.satyamevjayate.api.repo.FormVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

public class FormVerificationServices {
    @Autowired
    private FormVerificationRepository FormVerification_repo;

    public List<FormVerfication> listAllFormVerification()
    {
        return FormVerification_repo.findAll();
    }

    public void saveFormVerification(FormVerfication FormVerification)
    {
        FormVerification_repo.save(FormVerification);
    }

    public FormVerfication getFormVerification(BigInteger Id)
    {
        return FormVerification_repo.findById(Id).get();
    }

    public void deleteFormVerification(BigInteger Id)
    {
        FormVerification_repo.deleteById(Id);
    }
}
