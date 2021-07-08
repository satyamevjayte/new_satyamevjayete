package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
@RestController
public class CrimeImageController{
    @Autowired
    private com.satyamevjayate.api.services.CrimeImageServices crimeImageServices;

    @GetMapping("/crimeImage")
    public List<CrimeImage> getAllCrimeImage() {
        return crimeImageServices.listAllCrimeImage();
    }

    @GetMapping("/crimeImage/{id}")
    public CrimeImage getCrimeImage(@PathVariable Long id)
    {

        CrimeImage CrimeImage= crimeImageServices.getCrimeImage(id);
        return CrimeImage;



    }

    @PostMapping("/crimeImage")
    public String addCrimeImage(@RequestBody CrimeImage CrimeImage)
    {
        crimeImageServices.saveCrimeImage(CrimeImage);;
        return "CrimeImage Add Successfully";
    }


    @DeleteMapping("/crimeImage/{id}")
    public String deleteCrimeImage(@PathVariable Long id)
    {
        crimeImageServices.deleteCrimeImage(id);;
        return "Delete CrimeImage Successfully";
    }

    @PutMapping("/crimeImage/{id}")
    public ResponseEntity<Object> editCrimeImage(@RequestBody CrimeImage CrimeImage, @PathVariable Long id) {

        CrimeImage.setCrimeImageID(id);

        crimeImageServices.saveCrimeImage(CrimeImage);

        return ResponseEntity.noContent().build();
    }
}
