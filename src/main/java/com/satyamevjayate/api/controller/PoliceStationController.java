package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.PoliceStation;
import com.satyamevjayate.api.services.PoliceStationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
@RestController
public class PoliceStationController {
    @Autowired
    private PoliceStationServices PoliceStationService;

    @GetMapping("/policestations")
    public List<PoliceStation> getPoliceAllStation() {
        return PoliceStationService.listAll_PoliceStation();
    }

    @GetMapping("/policestations/{id}")
    public PoliceStation getPoliceStation(@PathVariable Long id)
    {
        PoliceStation p= PoliceStationService.getPoliceStation(id);
        return p;
    }

    @PostMapping("/policestations")
    public String addPoliceStation(@RequestBody PoliceStation p)
    {
        PoliceStationService.save_PoliceStation(p);
        return "PoliceStation Add successfully";

    }

    @DeleteMapping("/policestations/{id}")
    public String deletePoliceStation(@PathVariable Long id)
    {
        PoliceStationService.delete_PoliceStation(id);
        return "PoliceStation Delete successfully";
    }

    @PutMapping("/policestations/{id}")
    public ResponseEntity<Object> editPoliceStation(@RequestBody PoliceStation PoliceStation, @PathVariable Long id) {


        PoliceStation.setPoliceStationID(id);

        PoliceStationService.save_PoliceStation(PoliceStation);

        return ResponseEntity.noContent().build();
    }
}
