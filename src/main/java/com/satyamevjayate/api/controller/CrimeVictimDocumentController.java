package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeVictimDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
@RestController
public class CrimeVictimDocumentController {
    @Autowired
    private com.satyamevjayate.api.services.CrimeVictimDocumentService crimeVictimDocumentServices;

    @GetMapping("/crimevictimdocument")
    public List<CrimeVictimDocument> getAllCrimeVictimDocument() {
        return crimeVictimDocumentServices.listAllCrimeVictimDocument();
    }

    @GetMapping("/crimevictimdocument/{id}")
    public CrimeVictimDocument getCrimeVictimDocument(@PathVariable Long id)
    {

        CrimeVictimDocument CrimeVictimDocument= crimeVictimDocumentServices.getCrimeVictimDocument(id);
        return CrimeVictimDocument;



    }

    @PostMapping("/crimevictimdocument")
    public String addCrimeVictimDocument(@RequestBody CrimeVictimDocument CrimeVictimDocument)
    {
        crimeVictimDocumentServices.saveCrimeVictimDocument(CrimeVictimDocument);;
        return "CrimeVictimDocument Add Successfully";
    }


    @DeleteMapping("/crimevictimdocument/{id}")
    public String deleteCrimeVictimDocument(@PathVariable Long id)
    {
        crimeVictimDocumentServices.deleteCrimeVictimDocument(id);;
        return "Delete CrimeVictimDocument Successfully";
    }

    @PutMapping("/crimevictimdocument/{id}")
    public ResponseEntity<Object> editCrimeVictimDocument(@RequestBody CrimeVictimDocument CrimeVictimDocument, @PathVariable Long id) {

        CrimeVictimDocument.setDocumentID(id);

        crimeVictimDocumentServices.saveCrimeVictimDocument(CrimeVictimDocument);

        return ResponseEntity.noContent().build();
    }
}
