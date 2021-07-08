package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeSuspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CrimeSuspectController {  
    @Autowired
private com.satyamevjayate.api.services.CrimeSuspectServices crimeSuspectServices;

    @GetMapping("/crimesuspect")
    public List<CrimeSuspect> getAllCrimeSuspect() {
        return crimeSuspectServices.listAllCrimeSuspect();
    }

    @GetMapping("/crimesuspect/{id}")
    public CrimeSuspect getCrimeSuspect(@PathVariable Long id)
    {

        CrimeSuspect CrimeSuspect= crimeSuspectServices.getCrimeSuspect(id);
        return CrimeSuspect;



    }

    @PostMapping("/crimesuspect")
    public String addCrimeSuspect(@RequestBody CrimeSuspect CrimeSuspect)
    {
        crimeSuspectServices.saveCrimeSuspect(CrimeSuspect);;
        return "CrimeSuspect Add Successfully";
    }


    @DeleteMapping("/crimesuspect/{id}")
    public String deleteCrimeSuspect(@PathVariable Long id)
    {
        crimeSuspectServices.deleteCrimeSuspect(id);;
        return "Delete CrimeSuspect Successfully";
    }

    @PutMapping("/crimesuspect/{id}")
    public ResponseEntity<Object> editCrimeSuspect(@RequestBody CrimeSuspect CrimeSuspect, @PathVariable Long id) {

        CrimeSuspect.setCrimeSuspectID(id);

        crimeSuspectServices.saveCrimeSuspect(CrimeSuspect);

        return ResponseEntity.noContent().build();
    }

}
