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
    private ComplainerServices complainerServices;

    @GetMapping("/complainers")
    public List<Complainer> getAllComplainer() {
        return complainerServices.listAllComplainer();
    }

    @GetMapping("/complainers/{id}")
    public Complainer getComplainer(@PathVariable Long id)
    {
        Complainer complainer= complainerServices.getComplainer(id);
        return complainer;
    }

    @PostMapping("/complainers")
    public String addComplainer(@RequestBody Complainer complainer)
    {
        complainerServices.saveComplainer(complainer);
        return "Complain Add Successfully";
    }


    @DeleteMapping("/complainers/{id}")
    public String deleteComplainer(@PathVariable Long id)
    {
        complainerServices.deleteComplainer(id);
        return "Delete complain Successfully";
    }

    @PutMapping("/complainers/{id}")
    public ResponseEntity<Object> editComplainer(@RequestBody Complainer complainer, @PathVariable Long id) {



        complainer.setComplainerID(id);;

        complainerServices.saveComplainer(complainer);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value="/complainerslogin")
    public Complainer complainerLogin(@RequestHeader("contactEmail")String contactEmail,@RequestHeader("pwd")String pwd){
        Complainer complainer=complainerServices.complainerLogin(contactEmail,pwd);
        return complainer;
    }

}
