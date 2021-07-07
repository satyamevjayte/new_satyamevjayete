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
    private ComplainServices complain_Services;

    @GetMapping("/complains")
    public List<Complain> getAllComplain() {
        return complain_Services.listAllComplain();
    }

    @GetMapping("/complains/{id}")
    public Complain getComplain(@PathVariable Long id)
    {
        Complain complain= complain_Services.getComplain(id);
        return complain;
    }

    @PostMapping("/complains")
    public String addComplain(@RequestBody Complain complain)
    {
        complain_Services.saveComplain(complain);
        return "Complain Add Successfully";
    }


    @DeleteMapping("/complains/{id}")
    public String deleteComplain(@PathVariable Long id)
    {
        complain_Services.deleteComplain(id);
        return "Delete complain Successfully";
    }

    @PutMapping("/complains/{id}")
    public ResponseEntity<Object> editComplain(@RequestBody Complain complain, @PathVariable Long id) {



        complain.setComplainID(id);;

        complain_Services.saveComplain(complain);

        return ResponseEntity.noContent().build();
    }


}
