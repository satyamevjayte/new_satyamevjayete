package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.PoliceDocument;
import com.satyamevjayate.api.services.PoliceDocumentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PoliceDocumentController {
    @Autowired
    private PoliceDocumentServices policeDocumentServices;

    @GetMapping("/policerdocuments")
    public List<PoliceDocument> getAllPoliceDocument() {
        return policeDocumentServices.listAllPoliceDocument();
    }

    @GetMapping("/policerdocuments/{id}")
    public PoliceDocument getPoliceDocument(@PathVariable Long id)
    {
        PoliceDocument policeDocument= policeDocumentServices.getPoliceDocument(id);
        return policeDocument;
    }

    @PostMapping("/policerdocuments")
    public Long addPoliceDocument(@RequestBody PoliceDocument policeDocument)
    {
        Long documentID=policeDocumentServices.savePoliceDocument(policeDocument);

        return documentID;

    }

    @DeleteMapping("/policerdocuments/{id}")
    public String deletePoliceDocument(@PathVariable Long id)
    {
        policeDocumentServices.delete_PoliceDocument(id);
        return "PoliceDocument Delete successfully";
    }

    @PutMapping("/policerdocuments/{id}")
    public Long editPoliceDocument(@RequestBody PoliceDocument policeDocument, @PathVariable Long id) {


        Long documentID=policeDocumentServices.editPoliceDocument(policeDocument,id);

        return documentID;
    }

}
