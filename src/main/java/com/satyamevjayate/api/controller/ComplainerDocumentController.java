package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.Complainer;
import com.satyamevjayate.api.entity.ComplainerDocument;
import com.satyamevjayate.api.services.ComplainerDocumentServices;
import com.satyamevjayate.api.services.ComplainerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComplainerDocumentController {
    @Autowired
    private ComplainerDocumentServices complainerDocumentServices;

    @GetMapping("/complainerdocuments")
    public List<ComplainerDocument> getAllComplainerDocument() {
        return complainerDocumentServices.listAllComplainerDocument();
    }

    @GetMapping("/complainerdocuments/{id}")
    public ComplainerDocument getComplainerDocument(@PathVariable Long id)
    {
        ComplainerDocument complainerDocument= complainerDocumentServices.getComplainerDocument(id);
        return complainerDocument;
    }

    @PostMapping("/complainerdocuments")
    public String addComplainerDocument(@RequestBody ComplainerDocument complainerDocument)
    {
        complainerDocumentServices.saveComplainerDocument(complainerDocument);
        return "ComplainerDocument Add Successfully";
    }


    @DeleteMapping("/complainerdocuments/{id}")
    public String deleteComplainerDocument(@PathVariable Long id)
    {
        complainerDocumentServices.deleteComplainerDocument(id);
        return "Delete complainerDocument Successfully";
    }

    @PutMapping("/complainerdocuments/{id}")
    public ResponseEntity<Object> editComplainerDocument(@RequestBody ComplainerDocument complainerDocument, @PathVariable Long id) {



        complainerDocument.setDocumentID(id);;

        complainerDocumentServices.saveComplainerDocument(complainerDocument);

        return ResponseEntity.noContent().build();
    }

}
