package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeVictim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CrimeVictimController {
    @Autowired
    private com.satyamevjayate.api.services.CrimeVictimServices crimeVictimServices;

    @GetMapping("/crimevictims")
    public List<CrimeVictim> getAllCrimeVictim() {
        return crimeVictimServices.listAllCrimeVictim();
    }

    @GetMapping("/crimevictims/{id}")
    public CrimeVictim getCrimeVictim(@PathVariable Long id)
    {

        CrimeVictim CrimeVictim= crimeVictimServices.getCrimeVictim(id);
        return CrimeVictim;



    }

    @PostMapping("/crimevictims")
    public String addCrimeVictim(@RequestBody CrimeVictim CrimeVictim)
    {
        crimeVictimServices.saveCrimeVictim(CrimeVictim);;
        return "CrimeVictim Add Successfully";
    }


    @DeleteMapping("/crimevictims/{id}")
    public String deleteCrimeVictim(@PathVariable Long id)
    {
        crimeVictimServices.deleteCrimeVictim(id);;
        return "Delete CrimeVictim Successfully";
    }

    @PutMapping("/crimevictims/{id}")
    public ResponseEntity<Object> editCrimeVictim(@RequestBody CrimeVictim CrimeVictim, @PathVariable Long id) {

        CrimeVictim.setCrimeVictimID(id);

        crimeVictimServices.saveCrimeVictim(CrimeVictim);

        return ResponseEntity.noContent().build();
    }
}
