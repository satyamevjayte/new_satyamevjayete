package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.PrisonerLaw;
import com.satyamevjayate.api.entity.Prisoners;
import com.satyamevjayate.api.services.PrisonerLawServices;
import com.satyamevjayate.api.services.PrisonerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrisonersController {
    @Autowired
    private PrisonerServices prisonerServices;

    @GetMapping("/prisoners")
    public List<Prisoners> getAllPrisonerLaw() {
        return prisonerServices.listAllPrisoners();
    }

    @GetMapping("/prisoners/{id}")
    public Prisoners getPrisoners(@PathVariable Long id)
    {
        Prisoners prisoners= prisonerServices.getPrisoners(id);
        return prisoners;
    }

    @PostMapping("/prisoners")
    public Long addPrisoners(@RequestBody Prisoners prisoners)
    {
        Long prisonersID=prisonerServices.savePrisoners(prisoners);

        return prisonersID;

    }

    @DeleteMapping("/prisoners/{id}")
    public String deletePrisoners(@PathVariable Long id)
    {
        prisonerServices.deletePrisoners(id);
        return "Prisoners Delete successfully";
    }

    @PutMapping("/prisoners/{id}")
    public Long editPrisoners(@RequestBody Prisoners prisoners, @PathVariable Long id) {


        Long prisonerLawID=prisonerServices.editPrisoners(prisoners,id);

        return prisonerLawID;
    }
}
