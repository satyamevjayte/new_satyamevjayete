package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.ComplainLaw;
import com.satyamevjayate.api.entity.CrimeEvidence;
import com.satyamevjayate.api.services.ComplainLawServices;
import com.satyamevjayate.api.services.CrimeEvidenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CrimeEvidenceController {
    @Autowired
    private CrimeEvidenceServices crimeEvidenceServices;

    @GetMapping("/crimeevidences")
    public List<CrimeEvidence> getAllCrimeEvidence() {
        return crimeEvidenceServices.listAllCrimeEvidence();
    }

    @GetMapping("/crimeevidences/{id}")
    public CrimeEvidence getCrimeEvidence(@PathVariable Long id)
    {
        CrimeEvidence crimeEvidence= crimeEvidenceServices.getCrimeEvidence(id);
        return crimeEvidence;
    }

    @PostMapping("/crimeevidence")
    public String addCrimeEvidence(@RequestBody CrimeEvidence crimeEvidence)
    {
        crimeEvidenceServices.saveCrimeEvidence(crimeEvidence);
        return "CrimeEvidence Add Successfully";
    }


    @DeleteMapping("/crimeevidence/{id}")
    public String deleteCrimeEvidence(@PathVariable Long id)
    {
        crimeEvidenceServices.deleteCrimeEvidence(id);
        return "Delete crimeEvidence Successfully";
    }

    @PutMapping("/crimeevidence/{id}")
    public ResponseEntity<Object> editCrimeEvidence(@RequestBody CrimeEvidence crimeEvidence, @PathVariable Long id) {



        crimeEvidence.setEvidenceID(id);

        crimeEvidenceServices.saveCrimeEvidence(crimeEvidence);

        return ResponseEntity.noContent().build();
    }
}
