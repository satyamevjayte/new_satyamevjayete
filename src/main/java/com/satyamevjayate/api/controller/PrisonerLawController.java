package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.Prison;
import com.satyamevjayate.api.entity.PrisonerLaw;
import com.satyamevjayate.api.services.PrisonServices;
import com.satyamevjayate.api.services.PrisonerLawServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrisonerLawController {
    @Autowired
    private PrisonerLawServices prisonerLawServices;

    @GetMapping("/prisonerlaws")
    public List<PrisonerLaw> getAllPrisonerLaw() {
        return prisonerLawServices.listAllPrisonerLaw();
    }

    @GetMapping("/prisonerlaws/{id}")
    public PrisonerLaw getPrisonerLaw(@PathVariable Long id)
    {
        PrisonerLaw prisonerLaw= prisonerLawServices.getPrisonerLaw(id);
        return prisonerLaw;
    }

    @PostMapping("/prisonerlaws")
    public Long addPrisonerLaw(@RequestBody PrisonerLaw prisonerLaw)
    {
        Long prisonerLawID=prisonerLawServices.savePrisonerLaw(prisonerLaw);

        return prisonerLawID;

    }

    @DeleteMapping("/prisonerlaws/{id}")
    public String deletePrisonerLaw(@PathVariable Long id)
    {
        prisonerLawServices.deletePrisonerLaw(id);
        return "PrisonerLaw Delete successfully";
    }

    @PutMapping("/prisonerlaws/{id}")
    public Long editPrisonerLaw(@RequestBody PrisonerLaw prisonerLaw, @PathVariable Long id) {


        Long prisonerLawID=prisonerLawServices.editPrisonerLaw(prisonerLaw,id);

        return prisonerLawID;
    }
}
