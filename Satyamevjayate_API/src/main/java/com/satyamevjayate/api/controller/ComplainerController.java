package com.satyamevjayate.api.controller;


import com.satyamevjayate.api.entity.Complainer;
import com.satyamevjayate.api.services.ComplainerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComplainerController {
    @Autowired
    private ComplainerServices complainer_Services;

    @GetMapping("/complainers")
    public List<Complainer> getAllComplainer() {
        return complainer_Services.listAllComplainer();
    }

    @GetMapping("/complainers/{id}")
    public Complainer getComplainer(@PathVariable Long id)
    {
        Complainer complainer= complainer_Services.getComplainer(id);
        return complainer;
    }

    @PostMapping("/complainers")
    public String addComplainer(@RequestBody Complainer complainer)
    {
        complainer_Services.saveComplainer(complainer);
        return "Complain Add Successfully";
    }


    @DeleteMapping("/complainers/{id}")
    public String deleteComplainer(@PathVariable Long id)
    {
        complainer_Services.deleteComplainer(id);
        return "Delete complain Successfully";
    }

    @PutMapping("/complainers/{id}")
    public ResponseEntity<Object> editComplainer(@RequestBody Complainer complainer, @PathVariable Long id) {



        complainer.setComplainerID(id);;

        complainer_Services.saveComplainer(complainer);

        return ResponseEntity.noContent().build();
    }

}
