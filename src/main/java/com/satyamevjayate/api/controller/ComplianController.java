package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Complain;
import com.satyamevjayate.api.services.ComplainServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class ComplianController {
    @Autowired
    private ComplainServices complainServices;

    @GetMapping("/complains")
    public List<Complain> getAllComplain() {
        return complainServices.listAllComplain();
    }

    @GetMapping("/complains/{id}")
    public Complain getComplain(@PathVariable Long id)
    {
        Complain complain= complainServices.getComplain(id);
        return complain;
    }

    @PostMapping("/complains")
    public String addComplain(@RequestBody Complain complain)
    {
        complainServices.saveComplain(complain);
        return "Complain Add Successfully";
    }


    @DeleteMapping("/complains/{id}")
    public String deleteComplain(@PathVariable Long id)
    {
        complainServices.deleteComplain(id);
        return "Delete complain Successfully";
    }

    @PutMapping("/complains/{id}")
    public ResponseEntity<Object> editComplain(@RequestBody Complain complain, @PathVariable Long id) {



        complain.setComplainID(id);;

        complainServices.saveComplain(complain);

        return ResponseEntity.noContent().build();
    }


}
