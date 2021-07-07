package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.PoliceDocument;
import com.satyamevjayate.api.entity.Prison;
import com.satyamevjayate.api.services.PoliceDocumentServices;
import com.satyamevjayate.api.services.PrisonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrisonController {
    @Autowired
    private PrisonServices prisonServices;

    @GetMapping("/prisons")
    public List<Prison> getAllPrison() {
        return prisonServices.listAllPrison();
    }

    @GetMapping("/prisons/{id}")
    public Prison getPrison(@PathVariable Long id)
    {
        Prison prison= prisonServices.getPrison(id);
        return prison;
    }

    @PostMapping("/prisons")
    public Long addPrison(@RequestBody Prison prison)
    {
        Long prisonID=prisonServices.savePrison(prison);

        return prisonID;

    }

    @DeleteMapping("/prisons/{id}")
    public String deletePrison(@PathVariable Long id)
    {
        prisonServices.deletePrison(id);
        return "Prison Delete successfully";
    }

    @PutMapping("/prisons/{id}")
    public Long editPrison(@RequestBody Prison prison, @PathVariable Long id) {


        Long prisonID=prisonServices.editPrison(prison,id);

        return prisonID;
    }
    @GetMapping("/totalPrison")
    public Long  gettotalPolice()
    {
        Long count=prisonServices.findTotalPrison();
        return count;
    }
}
