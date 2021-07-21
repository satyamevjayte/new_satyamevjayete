package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.FromVerfication1;
import com.satyamevjayate.api.services.FormVerificationServices1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormVerficationController1 {
    @Autowired
    private FormVerificationServices1 formVerificationServices1;

    @GetMapping("/FromVerfication1")
    public List<FromVerfication1> getAllFromVerfication1() {
        return formVerificationServices1.listAllFromVerfication1();
    }

    @GetMapping("/FromVerfication1/{id}")
    public FromVerfication1 getFromVerfication1(@PathVariable Long id)
    {
        FromVerfication1 fv= formVerificationServices1.getFromVerfication1(id);
        return fv;
    }

    @PostMapping("/FromVerfication1")
    public Long addFromVerfication1(@RequestBody FromVerfication1 fv)
    {
        Long formVerifiactionID=formVerificationServices1.savePrisoners(fv);
        return formVerifiactionID;

    }

    @DeleteMapping("/FromVerfication1/{id}")
    public String deleteFromVerfication1(@PathVariable Long id)
    {
        formVerificationServices1.deleteFromVerfication1(id);
        return "FromVerfication1 Delete successfully";
    }

    @PutMapping("/FromVerfication1/{id}")
    public Long editFromVerfication1(@RequestBody FromVerfication1 fv, @PathVariable Long id) {

        Long formVerifiactionID=formVerificationServices1.editFromVerfication1(fv, id);
        return formVerifiactionID;
    }
}
