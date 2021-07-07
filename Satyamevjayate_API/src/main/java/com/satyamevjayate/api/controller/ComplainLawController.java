package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.ComplainLaw;
import com.satyamevjayate.api.entity.ComplainerDocument;
import com.satyamevjayate.api.services.ComplainLawServices;
import com.satyamevjayate.api.services.ComplainerDocumentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComplainLawController {
    @Autowired
    private ComplainLawServices complainLawServices;

    @GetMapping("/complainerLaws")
    public List<ComplainLaw> getAllComplainLaw() {
        return complainLawServices.listAllComplainLaw();
    }

    @GetMapping("/complainerLaws/{id}")
    public ComplainLaw getComplainLaw(@PathVariable Long id)
    {
        ComplainLaw complainLaw= complainLawServices.getComplainLaw(id);
        return complainLaw;
    }

    @PostMapping("/complainerLaws")
    public String addComplainLaw(@RequestBody ComplainLaw complainLaw)
    {
        complainLawServices.saveComplainLaw(complainLaw);
        return "ComplainerLaw Add Successfully";
    }


    @DeleteMapping("/complainerLaws/{id}")
    public String deleteComplainLaw(@PathVariable Long id)
    {
        complainLawServices.deleteComplainLaw(id);
        return "Delete complainerLaw Successfully";
    }

    @PutMapping("/complainerLaws/{id}")
    public ResponseEntity<Object> editComplainLaw(@RequestBody ComplainLaw complainLaw, @PathVariable Long id) {



        complainLaw.setComplainLawID(id);

        complainLawServices.saveComplainLaw(complainLaw);

        return ResponseEntity.noContent().build();
    }
}
