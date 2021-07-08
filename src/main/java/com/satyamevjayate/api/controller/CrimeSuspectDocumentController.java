package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeSuspectDocument;
import com.satyamevjayate.api.services.CrimeSuspectDocumentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CrimeSuspectDocumentController {
    @Autowired
    private CrimeSuspectDocumentServices crimeSuspectDocumentServices;

    @GetMapping("/crimesuspectdocument")
    public List<CrimeSuspectDocument> getAllCrimeSuspectDocument() {
        return crimeSuspectDocumentServices.listAllCrimeSuspectDocument();
    }

    @GetMapping("/crimesuspectdocument/{id}")
    public CrimeSuspectDocument getCrimeSuspectDocument(@PathVariable Long id)
    {

        CrimeSuspectDocument CrimeSuspectDocument= crimeSuspectDocumentServices.getCrimeSuspectDocument(id);
        return CrimeSuspectDocument;

    }

    @PostMapping("/crimesuspectdocument")
    public String addCrimeSuspectDocument(@RequestBody CrimeSuspectDocument CrimeSuspectDocument)
    {
        crimeSuspectDocumentServices.saveCrimeSuspectDocument(CrimeSuspectDocument);;
        return "CrimeSuspectDocument Add Successfully";
    }


    @DeleteMapping("/crimesuspectdocument/{id}")
    public String deleteCrimeSuspectDocument(@PathVariable Long id)
    {
        crimeSuspectDocumentServices.deleteCrimeSuspectDocument(id);;
        return "Delete CrimeSuspectDocument Successfully";
    }

    @PutMapping("/crimesuspectdocument/{id}")
    public ResponseEntity<Object> editCrimeSuspectDocument(@RequestBody CrimeSuspectDocument CrimeSuspectDocument, @PathVariable Long id) {

        CrimeSuspectDocument.setDocumentID(id);
        crimeSuspectDocumentServices.saveCrimeSuspectDocument(CrimeSuspectDocument);

        return ResponseEntity.noContent().build();
    }
}
