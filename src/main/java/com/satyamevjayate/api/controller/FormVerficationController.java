package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.FormVerfication;
import com.satyamevjayate.api.services.FormVerificationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormVerficationController {
    @Autowired
    private FormVerificationServices formVerificationServices;

    @GetMapping("/fromverfication")
    public List<FormVerfication>getAllFormVerfication(){return formVerificationServices.listformverfication();}

    @GetMapping("/fromverfication/{id}")
    public FormVerfication getFormVerfication(@PathVariable Long id){
        FormVerfication fv=formVerificationServices.getFormVefication(id);
        return fv;
    }

    @PostMapping("/fromverfication")
    public String addFormVerfication(@RequestBody FormVerfication fv){
        formVerificationServices.saveFormVerfication(fv);
        return "add";
    }
    @DeleteMapping("/fromverfication/{id}")
    public String deleteFormVerfication(@PathVariable Long id)
    {
            formVerificationServices.deleteFromVerfication(id);
        return "delete";
    }

    @PutMapping("/fromverfication/{id}")
    public ResponseEntity<Object> editFormVerfication(@RequestBody FormVerfication formVerfication,@PathVariable Long id){
        formVerfication.setFormVerifiactionID(id);
        formVerificationServices.editFormVerfication(formVerfication);
        return ResponseEntity.noContent().build();
    }
}
