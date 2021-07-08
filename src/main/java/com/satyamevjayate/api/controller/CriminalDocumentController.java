package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CriminalDocument;
import com.satyamevjayate.api.services.CriminalDocumentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CriminalDocumentController {
    @Autowired
    private CriminalDocumentServices  criminalDocumentServices;

    @GetMapping("/criminaldocument")
    public List<CriminalDocument> getAllCriminalDocument() {
        return criminalDocumentServices.listAllCriminalDocument();
    }

    @GetMapping("/criminaldocument/{id}")
    public CriminalDocument getCriminalDocument(@PathVariable Long id)
    {

        CriminalDocument CriminalDocument= criminalDocumentServices.getCriminalDocument(id);
        return CriminalDocument;



    }

    @PostMapping("/criminaldocument")
    public String addCriminalDocument(@RequestBody CriminalDocument CriminalDocument)
    {
        criminalDocumentServices.saveCriminalDocument(CriminalDocument);;
        return "CriminalDocument Add Successfully";
    }


    @DeleteMapping("/criminaldocument/{id}")
    public String deleteCriminalDocument(@PathVariable Long id)
    {
        criminalDocumentServices.deleteCriminalDocument(id);;
        return "Delete CriminalDocument Successfully";
    }

    @PutMapping("/criminaldocument/{id}")
    public ResponseEntity<Object> editCriminalDocument(@RequestBody CriminalDocument CriminalDocument, @PathVariable Long id) {

        CriminalDocument.setDocumentID(id);
        criminalDocumentServices.saveCriminalDocument(CriminalDocument);

        return ResponseEntity.noContent().build();
    }
}
