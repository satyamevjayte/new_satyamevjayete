package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.model.CRimeTypewiseCrime;
import com.satyamevjayate.api.services.CrimeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CrimeController {
    @Autowired
    private CrimeServices crimeServices;

    @GetMapping("/crime")
    public List<Crime> getAllCrime() {
        return crimeServices.listAllCrime();
    }

    @GetMapping("/crime/{id}")
    public Crime getCrime(@PathVariable BigInteger id)
    {

        Crime Crime= crimeServices.getCrime(id);
        return Crime;

    }

    @PostMapping("/crime")
    public String addCrime(@RequestBody Crime Crime)
    {
        crimeServices.saveCrime(Crime);;
        return "Crime Add Successfully";
    }
    @GetMapping("/crimewise")
    public List<CRimeTypewiseCrime>  getCrimetypewiseCrime()
    {
        List<CRimeTypewiseCrime> crimeCrimeTypewise= crimeServices.findCrimeCrimeTypewise();
        return crimeCrimeTypewise;
    }


    @DeleteMapping("/crime/{id}")
    public String deleteCrime(@PathVariable BigInteger id)
    {
        crimeServices.deleteCrime(id);;
        return "Delete Crime Successfully";
    }

    @PutMapping("/crime/{id}")
    public ResponseEntity<Object> editCrime(@RequestBody Crime Crime, @PathVariable BigInteger id) {

        Crime.setCrimeID(id);

        crimeServices.saveCrime(Crime);

        return ResponseEntity.noContent().build();
    }
    @GetMapping("/totalCrime")
    public Long  gettotalCrime()
    {
        Long count=crimeServices.findTotalCrime();
        return count;
    }

}
