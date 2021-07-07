package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeVictim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

public class CrimeVictimController {
    @Autowired
    private com.satyamevjayate.api.services.CrimeVictimServices CrimeVictim_Services;

    @GetMapping("/crimevictims")
    public List<CrimeVictim> getAllCrimeVictim() {
        return CrimeVictim_Services.listAllCrimeVictim();
    }

    @GetMapping("/crimevictims/{id}")
    public CrimeVictim getCrimeVictim(@PathVariable BigInteger id)
    {

        CrimeVictim CrimeVictim= CrimeVictim_Services.getCrimeVictim(id);
        return CrimeVictim;



    }

    @PostMapping("/crimevictims")
    public String addCrimeVictim(@RequestBody CrimeVictim CrimeVictim)
    {
        CrimeVictim_Services.saveCrimeVictim(CrimeVictim);;
        return "CrimeVictim Add Successfully";
    }


    @DeleteMapping("/crimevictims/{id}")
    public String deleteCrimeVictim(@PathVariable BigInteger id)
    {
        CrimeVictim_Services.deleteCrimeVictim(id);;
        return "Delete CrimeVictim Successfully";
    }

    @PutMapping("/crimevictims/{id}")
    public ResponseEntity<Object> editCrimeVictim(@RequestBody CrimeVictim CrimeVictim, @PathVariable BigInteger id) {

        CrimeVictim.setCrimeVictimID(id);

        CrimeVictim_Services.saveCrimeVictim(CrimeVictim);

        return ResponseEntity.noContent().build();
    }
}
